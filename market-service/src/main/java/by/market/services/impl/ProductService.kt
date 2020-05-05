package by.market.services.impl

import by.market.core.ProductFilter
import by.market.domain.Product
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.EntityMetadata
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.product.ProductRepository
import by.market.repository.system.EntityMetadataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Service
open class ProductService(rep: ProductRepository) : BaseProductService<Product, ProductRepository>(rep) {

    @Autowired private lateinit var stringSingleCharacteristicRepository: StringSingleCharacteristicRepository
    @Autowired private lateinit var doubleSingleCharacteristicRepository: DoubleSingleCharacteristicRepository
    @Autowired private lateinit var entityMetadataRepository: EntityMetadataRepository
    @Autowired private lateinit var baseProductFilterService: BaseProductFilterService<Product>;


    private val lazyEntityMetadata: EntityMetadata by lazy {
        entityMetadataRepository.findByTableName("product")
    }

    @Transactional(readOnly = true)
    override fun findDoubleCharacteristicById(id: UUID): List<DoubleCharacteristic> =
        doubleSingleCharacteristicRepository.findByEntityMetadataAndProduct(lazyEntityMetadata, getReference(id))

    override fun findStringCharacteristicById(id: UUID): List<StringCharacteristic> =
        stringSingleCharacteristicRepository.findByEntityMetadataAndProduct(lazyEntityMetadata, getReference(id))

    override fun findByFilter(filter: ProductFilter, category: UUID, pageable: Pageable): List<Product> =
        baseProductFilterService.findByFilter(filter, category, pageable)

    override fun countByFilter(filter: ProductFilter, category: UUID): Long =
        baseProductFilterService.countByFilter(filter, category)


}
