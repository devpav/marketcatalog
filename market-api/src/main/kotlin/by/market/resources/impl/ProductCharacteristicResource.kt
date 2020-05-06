package by.market.resources.impl

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.dto.characteristics.AbstractCharacteristicDTO
import by.market.dto.characteristics.ProductCharacteristicDTO
import by.market.facade.impl.ProductCharacteristicFacade
import by.market.facade.impl.ProductCharacteristicValueFacade
import by.market.mapper.entity_metadata.EntityMetadataProductCharacteristicMapper
import by.market.mapper.entity_metadata.EntityMetadataProductTypeMapper
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.system.CategoryRepository
import by.market.services.impl.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-characteristic")
class ProductCharacteristicResource(facade: ProductCharacteristicFacade) : AbstractResource<ProductCharacteristicDTO, ProductCharacteristicFacade>(facade){

    @Autowired private lateinit var stringCharacteristicRep: StringSingleCharacteristicRepository
    @Autowired private lateinit var doubleCharacteristicRep: DoubleSingleCharacteristicRepository
    @Autowired private lateinit var entityMetadataProductTypeMapper: EntityMetadataProductTypeMapper
    @Autowired private lateinit var entityMetadataProductCharacteristicMapper: EntityMetadataProductCharacteristicMapper
    @Autowired private lateinit var categoryRepository: CategoryRepository

    @Autowired private lateinit var productService: ProductService
    @Autowired private lateinit var productCharacteristicValueFacade: ProductCharacteristicValueFacade

    @PostMapping("/value")
    fun saveCharacteristicValue(@RequestBody abstractCharacteristicDTO: AbstractCharacteristicDTO<Any>): ResponseEntity<AbstractCharacteristic<Any>?> {
        return ResponseEntity.ok(productCharacteristicValueFacade.save(abstractCharacteristicDTO)!!)
    }

}
