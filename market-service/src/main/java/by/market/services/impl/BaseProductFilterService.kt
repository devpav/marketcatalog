package by.market.services.impl

import by.market.core.Constant
import by.market.core.FilterOperator
import by.market.core.ProductFilter
import by.market.core.ProductFilterItem
import by.market.domain.BaseEntity
import by.market.domain.characteristics.ProductCharacteristic
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.system.CategoryRepository
import by.market.services.BaseProductFilter
import org.springframework.data.domain.Pageable
import java.lang.reflect.ParameterizedType
import java.util.*
import javax.annotation.PostConstruct
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.TypedQuery
import javax.persistence.criteria.*

abstract class BaseProductFilterService<TEntity: BaseEntity> : BaseProductFilter<TEntity> {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    private lateinit var criteriaBuilder: CriteriaBuilder
    private lateinit var createQuery: CriteriaQuery<TEntity>
    private lateinit var root: Root<TEntity>
    private lateinit var classT: Class<TEntity>

    private lateinit var categoryRepository: CategoryRepository
    private lateinit var productCharacteristicRepository: ProductCharacteristicRepository


    init {
        val parameterizedType = this.javaClass.genericSuperclass as ParameterizedType
        classT = parameterizedType.actualTypeArguments[0] as Class<TEntity>
    }

    @PostConstruct
    fun init() {
        criteriaBuilder = entityManager.criteriaBuilder
        createQuery = criteriaBuilder.createQuery(classT)
        root = createQuery.from(classT)
    }

    override fun findByFilter(filter: ProductFilter, pageable: Pageable): MutableList<TEntity> {
        val predicates = collectPredicateByFilter(filter)

        val query = createQuery
                .select(root)
                .where(*predicates.toTypedArray())

        val result: TypedQuery<TEntity> = entityManager.createQuery(query)

        result.firstResult = pageable.pageNumber
        result.maxResults = pageable.pageSize.coerceAtLeast(5)

        return result.resultList
    }

    override fun countByFilter(filter: ProductFilter): Long {
        val predicates = collectPredicateByFilter(filter)
        val criteria: CriteriaQuery<Long> = criteriaBuilder.createQuery(Long::class.java)

        val query = criteria.select(criteriaBuilder.count(root))
                .where(*predicates.toTypedArray())

        val result: TypedQuery<Long> = entityManager.createQuery(query)

        return result.singleResult
    }

    private fun collectPredicateByFilter(filter: ProductFilter): MutableList<Predicate> {
        val predicates: MutableList<Predicate> = mutableListOf()

        val category = categoryRepository.getOne(UUID.fromString(filter.category))

        predicates.add(criteriaBuilder.equal(root.get<Any>("category"), category))

        filter.filters.forEach {
            if (it.value.isEmpty()) {
                return@forEach
            }

            val characteristicOptional = productCharacteristicRepository.findById(it.id_charact)

            if (characteristicOptional.isPresent) {
                return@forEach
            }

            val characteristic = characteristicOptional.get()
            val dataType = characteristic.dataType

            dataType ?: return@forEach

            fun <T> getPredicateSubquery(classValue: Class<T>): Predicate {
                val subqueryString = getSubqueryString(classValue, characteristic, it)
                return criteriaBuilder.exists(subqueryString)
            }

            val predicate: Predicate? = when (dataType.name) {
                Constant.DataType.String -> getPredicateSubquery(StringCharacteristic::class.java)
                Constant.DataType.Double -> getPredicateSubquery(DoubleCharacteristic::class.java)
                else -> null
            }

            predicate ?: return@forEach

            predicates.add(predicate)
        }

        return predicates
    }


    private fun <T> getSubqueryString(classQuery: Class<T>, productCharacteristic: ProductCharacteristic?, filter: ProductFilterItem): Subquery<T>? {
        val subquery = createQuery.subquery(classQuery);
        val from = subquery.from(classQuery)

        val fieldCharacteristic = from.get<Any>("productCharacteristic")
        val equalFieldCharacteristic = criteriaBuilder.equal(fieldCharacteristic, productCharacteristic)

        val fieldProductId = from.get<Any>("productRowId")
        val equalFieldProductId = criteriaBuilder.equal(fieldProductId, root.get<Any>("id"))

        val fieldValue = from.get<Any>("value")

        var inValues: Predicate? = null

        if (classQuery == StringCharacteristic::class.java) {
            inValues = fieldValue.`in`(filter.value)
        }

        fun toDoubles(strings: List<String>): List<Double> {
            return strings.map { it.toDouble() }
        }

        if (classQuery == DoubleCharacteristic::class.java) {
            when (filter.type) {
                FilterOperator.EQ -> inValues = fieldValue.`in`(toDoubles(filter.value))
                FilterOperator.FT -> {
                    val doubles = toDoubles(filter.value)
                    val zero = 0.0

                    if (doubles.isNotEmpty()) {
                        val fromDoubleTmp: Double? = doubles[0]
                        var fromDouble: Double = fromDoubleTmp ?: zero

                        var toDouble = Double.MAX_VALUE
                        if (doubles.size == 2) {
                            val doubleTmp: Double? = doubles[1]
                            toDouble = doubleTmp ?: toDouble
                        }

                        if (toDouble.compareTo(fromDouble) < zero) {
                            fromDouble = toDouble.also { toDouble = fromDouble }
                        }

                        inValues = criteriaBuilder.between(from.get<Double>("value"), fromDouble, toDouble)
                    }
                }
            }
        }

        return subquery.select(from).where(equalFieldCharacteristic, equalFieldProductId, inValues)
    }


}