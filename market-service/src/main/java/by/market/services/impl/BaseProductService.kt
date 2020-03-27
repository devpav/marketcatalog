package by.market.services.impl

import by.market.core.ProductFilter
import by.market.domain.AbstractProduct
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import by.market.domain.system.EntityMetadata
import by.market.repository.AbstractProductRepository
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.system.CategoryRepository
import by.market.repository.system.EntityMetadataRepository
import by.market.services.abstraction.IProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import java.lang.reflect.ParameterizedType
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseProductService<TEntity : AbstractProduct, TRepository : AbstractProductRepository<TEntity>>(rep: TRepository, private val tableName: String)
    : IProductService<TEntity>, BaseService<TEntity, TRepository>(rep) {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Autowired
    protected lateinit var stringSingleCharacteristicRepository: StringSingleCharacteristicRepository

    @Autowired
    protected lateinit var doubleSingleCharacteristicRepository: DoubleSingleCharacteristicRepository

    @Autowired
    private lateinit var entityMetadataRepository: EntityMetadataRepository

    @Autowired
    private lateinit var productCharacteristicRepository: ProductCharacteristicRepository

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Autowired
    private lateinit var baseProductFilterService: BaseProductFilterService<TEntity>;

    private val classT: Class<TEntity>


    private val lazyEntityMetadata: EntityMetadata by lazy {
        entityMetadataRepository.findByTableName(tableName)
    }

    init {
        val parameterizedType = this.javaClass.genericSuperclass as ParameterizedType
        classT = parameterizedType.actualTypeArguments[0] as Class<TEntity>
    }


    override fun findByCategory(category: Category, pageable: Pageable): MutableList<TEntity> {
        return rep.findByCategory(category, pageable)
    }

    override fun findByCategory(category: Category): List<TEntity> {
        return rep.findByCategory(category)
    }

    override fun countByCategory(category: Category): Long {
        return rep.countAllByCategory(category)
    }

    override fun findById(id: UUID): Optional<TEntity> {
        return rep.findById(id)
    }

    override fun findDoubleCharacteristicById(id: UUID): List<DoubleCharacteristic> {
        return doubleSingleCharacteristicRepository.findByEntityMetadataAndProductRowId(lazyEntityMetadata, id)
    }

    override fun findStringCharacteristicById(id: UUID): List<StringCharacteristic> {
        return stringSingleCharacteristicRepository.findByEntityMetadataAndProductRowId(lazyEntityMetadata, id)
    }

    override fun findByFilter(filter: ProductFilter, pageable: Pageable): List<TEntity> {
        return baseProductFilterService.findByFilter(filter, pageable)
    }

    override fun countByFilter(filter: ProductFilter): Long {
        return baseProductFilterService.countByFilter(filter)
    }

}
