package by.market.services

import by.market.domain.AbstractProduct
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import by.market.domain.system.EntityMetadata
import by.market.repository.AbstractProductRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.services.abstraction.IProductService
import java.lang.reflect.ParameterizedType
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.TypedQuery
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

abstract class BaseProductService<
        TEntity: AbstractProduct,
        TRepository: AbstractProductRepository<TEntity>
        >(rep: TRepository,
          protected val stringSingleCharacteristicRepository: StringSingleCharacteristicRepository,
          protected val doubleSingleCharacteristicRepository: DoubleSingleCharacteristicRepository)
    : IProductService<TEntity>, BaseService<TEntity, TRepository>(rep){

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    private val lazyEntityMetadata: EntityMetadata by lazy {
        getEntityMetadata()
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


    override fun findByFilter(title: String): List<TEntity> {
        val classT = (this.javaClass
                .genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<TEntity>

        val criteriaBuilder: CriteriaBuilder = entityManager.criteriaBuilder
        val createQuery: CriteriaQuery<TEntity> = criteriaBuilder.createQuery(classT)
        val root: Root<TEntity> = createQuery.from(classT)

        val predicateTitleLike: Predicate = criteriaBuilder.like(root.get("title"), "%$title%")

        val filterPredicate = getFilterPredicate(criteriaBuilder, createQuery, root)

        val predicate: Predicate = criteriaBuilder.and()

        val where = createQuery.select(root)
                .where(filterPredicate, predicateTitleLike, predicate)

        val result: TypedQuery<TEntity> = entityManager.createQuery(where)

        return result.resultList
    }

    protected fun getFilterPredicate(criteriaBuilder: CriteriaBuilder,
                                              createQuery: CriteriaQuery<TEntity>,
                                              root: Root<TEntity>): Predicate {
        return criteriaBuilder.and()
    }

}
