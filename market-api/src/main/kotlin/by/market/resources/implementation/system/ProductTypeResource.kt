package by.market.resources.implementation.system

import by.market.facade.system.ProductTypeFacade
import by.market.mapper.dto.system.ProductTypeFrontEnd
import by.market.resources.BaseMutableResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-type")
open class ProductTypeResource(facade: ProductTypeFacade)
    : BaseMutableResource<ProductTypeFrontEnd, ProductTypeFacade>(facade)
