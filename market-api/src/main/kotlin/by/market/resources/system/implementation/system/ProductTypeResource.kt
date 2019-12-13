package by.market.resources.system.implementation.system

import by.market.domain.system.ProductType
import by.market.resources.system.implementation.BaseMutableResource
import by.market.services.system.ProductTypeService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-type")
class ProductTypeResource(service: ProductTypeService)
    : BaseMutableResource<ProductTypeService, ProductType>(service)
