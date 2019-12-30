package by.market.resources.system.implementation.characteristic

import by.market.facade.characteristics.ProductCharacteristicFacade
import by.market.mapper.dto.characteristics.ProductCharacteristicFrontEnd
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-characteristic")
class ProductCharacteristicResource(facade: ProductCharacteristicFacade)
    : BaseCharacteristicResource<ProductCharacteristicFacade, ProductCharacteristicFrontEnd>(facade)
