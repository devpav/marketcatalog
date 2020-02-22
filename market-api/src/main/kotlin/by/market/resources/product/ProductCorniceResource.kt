package by.market.resources.product

import by.market.core.facade.product.ProductCorniceFacade
import by.market.dto.product.ProductCorniceDTO
import by.market.resources.BaseProductResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cornice-product")
class ProductCorniceResource(facade: ProductCorniceFacade) : BaseProductResource<ProductCorniceDTO>(facade)
