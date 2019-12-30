package by.market.resources.implementation.product

import by.market.facade.product.ProductCorniceFacade
import by.market.mapper.dto.product.ProductCorniceFrontEnd
import by.market.resources.BaseProductResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cornice-product")
class ProductCorniceResource(facade: ProductCorniceFacade)
    : BaseProductResource<ProductCorniceFacade, ProductCorniceFrontEnd>(facade)
