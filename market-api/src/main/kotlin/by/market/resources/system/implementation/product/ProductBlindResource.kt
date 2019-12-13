package by.market.resources.system.implementation.product

import by.market.domain.product.ProductBlind
import by.market.resources.system.implementation.BaseProductResource
import by.market.services.implementation.product.ProductBlindService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/blind-product")
class ProductBlindResource(service: ProductBlindService)
    : BaseProductResource<ProductBlindService, ProductBlind>(service)
