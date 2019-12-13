package by.market.resources.system.implementation.product

import by.market.domain.product.ProductAccessory
import by.market.resources.system.implementation.BaseProductResource
import by.market.services.implementation.product.ProductAccessoryService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/accessory-product")
class ProductAccessoryResource(service: ProductAccessoryService)
    : BaseProductResource<ProductAccessoryService, ProductAccessory>(service)
