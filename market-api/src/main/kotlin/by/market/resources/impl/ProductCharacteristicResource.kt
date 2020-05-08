package by.market.resources.impl

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.dto.characteristics.AbstractCharacteristicDTO
import by.market.dto.characteristics.ProductCharacteristicDTO
import by.market.facade.impl.ProductCharacteristicFacade
import by.market.facade.impl.ProductCharacteristicValueFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-characteristic")
class ProductCharacteristicResource(facade: ProductCharacteristicFacade) : AbstractResource<ProductCharacteristicDTO, ProductCharacteristicFacade>(facade){

    @Autowired private lateinit var productCharacteristicValueFacade: ProductCharacteristicValueFacade


    @PostMapping("/value")
    fun saveCharacteristicValue(@RequestBody abstractCharacteristicDTO: AbstractCharacteristicDTO<Any>): ResponseEntity<AbstractCharacteristic<Any>?> {
        return ResponseEntity.ok(productCharacteristicValueFacade.save(abstractCharacteristicDTO)!!)
    }

}
