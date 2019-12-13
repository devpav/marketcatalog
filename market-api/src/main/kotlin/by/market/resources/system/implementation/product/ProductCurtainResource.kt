package by.market.resources.system.implementation.product

import by.market.domain.product.ProductCurtain
import by.market.resources.system.implementation.BaseProductResource
import by.market.services.system.implementation.product.ProductCurtainService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/curtain-product")
class ProductCurtainResource(service: ProductCurtainService)
    : BaseProductResource<ProductCurtainService, ProductCurtain>(service)
