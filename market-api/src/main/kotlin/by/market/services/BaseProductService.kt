package by.market.services

import by.market.domain.AbstractProduct
import by.market.domain.characteristics.ProductCharacteristic
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import by.market.domain.system.EntityMetadata
import by.market.repository.AbstractProductRepository
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.system.CategoryRepository
import by.market.services.abstraction.IProductService
import by.market.services.filter.model.FilterOperator
import by.market.services.filter.model.ProductFilter
import by.market.services.filter.model.ProductFilterItem
import org.springframework.beans.factory.annotation.Autowired
import java.lang.reflect.ParameterizedType
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.TypedQuery
import javax.persistence.criteria.*


abstract class BaseProductService<
        TEntity : AbstractProduct,
        TRepository : AbstractProductRepository<TEntity>
        >(rep: TRepository,
          protected val stringSingleCharacteristicRepository: StringSingleCharacteristicRepository,
          protected val doubleSingleCharacteristicRepository: DoubleSingleCharacteristicRepository)
    : IProductService<TEntity>, BaseService<TEntity, TRepository>(rep) {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Autowired
    private lateinit var productCharacteristicRepository: ProductCharacteristicRepository

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    private val classT: Class<TEntity>


    private val lazyEntityMetadata: EntityMetadata by lazy {
        getEntityMetadata()
    }

    init {
        val parameterizedType = this.javaClass.genericSuperclass as ParameterizedType
        classT = parameterizedType.actualTypeArguments[0] as Class<TEntity>
    }

    override fun findByCategory(category: Category): List<TEntity> {
        return rep.findByCategory(category)
    }

    override fun findDoubleCharacteristicById(id: UUID): List<DoubleCharacteristic> {
        return doubleSingleCharacteristicRepository.findByEntityMetadataAndProductRowId(lazyEntityMetadata, id)
    }

    override fun findStringCharacteristicById(id: UUID): List<StringCharacteristic> {
        return stringSingleCharacteristicRepository.findByEntityMetadataAndProductRowId(lazyEntityMetadata, id)
    }

    protected abstract fun getEntityMetadata(): EntityMetadata


    override fun findByFilter(filter: ProductFilter): List<TEntity> {
        val criteriaBuilder: CriteriaBuilder = entityManager.criteriaBuilder
        val createQuery: CriteriaQuery<TEntity> = criteriaBuilder.createQuery(classT)
        val root: Root<TEntity> = createQuery.from(classT)

        val predicates: MutableList<Predicate> = mutableListOf()

        val category = categoryRepository.getOne(UUID.fromString(filter.category))

        predicates.add(criteriaBuilder.equal(root.get<Any>("category"), category))

        filter.filters.forEach {
            if (it.value.isNotEmpty()) {
                val characteristicOptional = productCharacteristicRepository.findById(it.id_charact)
                if (characteristicOptional.isPresent) {
                    val characteristic = characteristicOptional.get()
                    val dataType = characteristic.dataType
                    if (dataType != null) {
                        fun <T> getPredicateSubquery(classValue: Class<T>): Predicate {
                            val subqueryString = getSubqueryString(criteriaBuilder, createQuery, classValue, characteristic, root, it)
                            return criteriaBuilder.exists(subqueryString)
                        }
                        when (dataType.name) {
                            "STRING" -> {
                                predicates.add(getPredicateSubquery(StringCharacteristic::class.java))
                            }
                            "DOUBLE" -> {
                                predicates.add(
                                        getPredicateSubquery(DoubleCharacteristic::class.java)
                                )
                            }
                        }
                    }
                }
            }
        }

        val filterPredicate = getFilterPredicates(criteriaBuilder, createQuery, root)

        if (filterPredicate != null) {
            predicates.addAll(filterPredicate)
        }

        val where = createQuery.select(root).where(*predicates.toTypedArray())

        val result: TypedQuery<TEntity> = entityManager.createQuery(where)

        result.firstResult = filter.page ?: 0;
        result.maxResults = (filter.size ?: 0).coerceAtLeast(5);

        return result.resultList
    }

    private fun <T> getSubqueryString(criteriaBuilder: CriteriaBuilder,
                                      createQuery: CriteriaQuery<TEntity>,
                                      classQuery: Class<T>,
                                      productCharacteristic: ProductCharacteristic?,
                                      root: Root<TEntity>,
                                      filter: ProductFilterItem): Subquery<T>? {

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

        return subquery.select(from)
                .where(equalFieldCharacteristic, equalFieldProductId, inValues)
    }

    protected fun getFilterPredicates(criteriaBuilder: CriteriaBuilder, createQuery: CriteriaQuery<TEntity>,
                                      root: Root<TEntity>): MutableList<Predicate>? {
        return null
    }

}
