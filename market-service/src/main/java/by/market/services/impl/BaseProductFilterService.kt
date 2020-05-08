package by.market.services.impl

import by.market.core.Constant
import by.market.core.FilterOperator
import by.market.core.ProductFilter
import by.market.core.ProductFilterItem
import by.market.domain.Product
import by.market.domain.characteristics.Characteristic
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.system.CategoryRepository
import by.market.services.BaseProductFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional
import java.lang.reflect.ParameterizedType
import java.util.*
import javax.annotation.PostConstruct
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.TypedQuery
import javax.persistence.criteria.*

abstract class BaseProductFilterService<TEntity: Product> : BaseProductFilter<TEntity> {

    @PersistenceContext private lateinit var entityManager: EntityManager

    private lateinit var criteriaBuilder: CriteriaBuilder
    private lateinit var createQuery: CriteriaQuery<TEntity>
    private lateinit var root: Root<TEntity>

    private lateinit var classT: Class<TEntity>

    @Autowired private lateinit var categoryService: CategoryService

    @Autowired private lateinit var categoryRepository: CategoryRepository

    @Autowired private lateinit var productCharacteristicRepository: ProductCharacteristicRepository


    @PostConstruct fun init() {
        val parameterizedType = this.javaClass.genericSuperclass as ParameterizedType
        this.classT = parameterizedType.actualTypeArguments[0] as Class<TEntity>

        criteriaBuilder = entityManager.criteriaBuilder
        createQuery = criteriaBuilder.createQuery(classT)
        root = createQuery.from(classT)
    }


    @Transactional(readOnly = true)
    override fun findByFilter(filter: ProductFilter, category: UUID, pageable: Pageable): MutableList<TEntity> {
        val predicates = collectPredicateByFilter(filter, category)

        val query = createQuery.select(root)
                .where(*predicates.toTypedArray())

        val result: TypedQuery<TEntity> = entityManager.createQuery(query)

        result.firstResult = pageable.offset.toInt()
        result.maxResults = pageable.pageSize

        return result.resultList
    }

    override fun countByFilter(filter: ProductFilter, category: UUID): Long {
        val predicates = collectPredicateByFilter(filter, category)

        val criteriaQuery: CriteriaQuery<Long> = criteriaBuilder.createQuery(Long::class.java)

        val select = criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(classT)))
                .where(*predicates.toTypedArray())

        return entityManager.createQuery(select).singleResult
    }


    private fun collectPredicateByFilter(filter: ProductFilter, category: UUID): MutableList<Predicate> {
        val predicates: MutableList<Predicate> = mutableListOf()

        val entityCategory = categoryRepository.getOne(category) ?: return mutableListOf()

        val rootCategory = categoryService.findRootCategory(entityCategory.id!!) ?: return mutableListOf()

        val categories = categoryService.findAllByParentCategory(rootCategory)

        val mutableListOf = mutableListOf(*categories.toTypedArray())

        mutableListOf.add(rootCategory)

        predicates.add(root.get<Category>("category").`in`(categories))

        filter.filters.forEach {
            if (it.value.isEmpty()) {
                return@forEach
            }

            val characteristicOptional = productCharacteristicRepository.findById(it.characteristic)

            if (!characteristicOptional.isPresent) {
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

    private fun <T> getSubqueryString(classQuery: Class<T>, characteristic: Characteristic?, filter: ProductFilterItem): Subquery<T>? {
        val subquery = createQuery.subquery(classQuery);
        val from = subquery.from(classQuery)

        val fieldCharacteristic = from.get<Characteristic>("productCharacteristic")
        val equalFieldCharacteristic = criteriaBuilder.equal(fieldCharacteristic, characteristic)

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

                        inValues = criteriaBuilder.between(from.get("value"), fromDouble, toDouble)
                    }
                }
            }
        }

        return subquery
                .select(from)
                .where(equalFieldCharacteristic, equalFieldProductId, inValues)
    }


}