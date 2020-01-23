package by.market.resources.implementation.characteristic

import arrow.core.getOrElse
import by.market.core.ProductType
import by.market.domain.AbstractProduct
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.EntityMetadata
import by.market.facade.characteristics.ProductCharacteristicFacade
import by.market.mapper.domain_dto_mapper.system.CategoryMapper
import by.market.mapper.dto.characteristics.ProductCharacteristicFrontEnd
import by.market.mapper.dto.characteristics.UniversalCharacteristicFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.mapper.entity_metadata.EntityMetadataProductCharacteristicMapper
import by.market.mapper.entity_metadata.EntityMetadataProductTypeMapper
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.product.ProductAccessoryRepository
import by.market.repository.product.ProductCorniceRepository
import by.market.repository.product.ProductJalosieRepository
import by.market.repository.product.ProductRolstorRepository
import by.market.repository.system.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.Specification
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-characteristic")
class ProductCharacteristicResource(facade: ProductCharacteristicFacade)
    : BaseCharacteristicResource<ProductCharacteristicFacade, ProductCharacteristicFrontEnd>(facade){
    @Autowired
    private lateinit var stringCharacteristicRep: StringSingleCharacteristicRepository
    @Autowired
    private lateinit var doubleCharacteristicRep: DoubleSingleCharacteristicRepository
    @Autowired
    private lateinit var accessoryRepository: ProductAccessoryRepository
    @Autowired
    private lateinit var corniceRepository: ProductCorniceRepository
    @Autowired
    private lateinit var jalosieRepository: ProductJalosieRepository
    @Autowired
    private lateinit var rolstorRepository: ProductRolstorRepository
    @Autowired
    private lateinit var entityMetadataProductTypeMapper: EntityMetadataProductTypeMapper
    @Autowired
    private lateinit var entityMetadataProductCharacteristicMapper: EntityMetadataProductCharacteristicMapper
    @Autowired
    private lateinit var categoryRepository: CategoryRepository
    @Autowired
    private lateinit var categoryMapper: CategoryMapper

    @GetMapping("/findCharacteristic")
    fun findByCategory(category: CategoryFrontEnd): ResponseEntity<MutableList<UniversalCharacteristicFrontEnd>> {
        val categoryDatabase = categoryMapper.from(category)
        val categories = categoryRepository.findAllByParentCategory(categoryDatabase)

        val entityMetadata = categories.map { entityMetadataProductCharacteristicMapper.toFrom(it).orNull() }
                .filterNotNull()
                .mapNotNull { Pair(it, entityMetadataProductTypeMapper.fromTo(it).getOrElse { ProductType.Cornice }) }

        val productIds: MutableList<Pair<EntityMetadata, List<AbstractProduct>>> = mutableListOf()

        val stringCharSpec: Specification<StringCharacteristic>? = null
        val doubleCharSpec: Specification<DoubleCharacteristic>? = null

        entityMetadata.forEach {
            val ids = when(it.second) {
                ProductType.Accessories -> accessoryRepository.getAllIds()
                ProductType.Cornice -> corniceRepository.getAllIds()
                ProductType.Jalosie -> jalosieRepository.getAllIds()
                ProductType.Rolstor -> rolstorRepository.getAllIds()
            }

        }

        return findByCategory(category)
    }
}
