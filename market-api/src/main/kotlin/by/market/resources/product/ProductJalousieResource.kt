package by.market.resources.product

import by.market.core.facade.product.ProductJalousieFacade
import by.market.dto.product.ProductJalousieDTO
import by.market.resources.BaseProductResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/jalousie-product")
class ProductJalousieResource(facade: ProductJalousieFacade) : BaseProductResource<ProductJalousieDTO>(facade)
