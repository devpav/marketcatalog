package by.market.resources.system.implementation.product

import by.market.domain.product.ProductCornice
import by.market.resources.system.implementation.BaseProductResource
import by.market.services.implementation.product.ProductCorniceService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cornice-product")
class ProductCorniceResource(service: ProductCorniceService)
    : BaseProductResource<ProductCorniceService, ProductCornice>(service)
