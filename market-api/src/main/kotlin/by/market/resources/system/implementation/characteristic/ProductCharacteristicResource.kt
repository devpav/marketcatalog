package by.market.resources.system.implementation.characteristic

import by.market.domain.characteristics.ProductCharacteristic
import by.market.services.implementation.characteristic.ProductCharacteristicService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-characteristic")
class ProductCharacteristicResource(service: ProductCharacteristicService)
    : BaseCharacteristicResource<ProductCharacteristicService, ProductCharacteristic>(service)
