package by.market.resources.impl

import by.market.dto.product.ProductDTO
import by.market.facade.impl.ProductFacade
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductResource(facade: ProductFacade) : BaseProductResource<ProductDTO, ProductFacade>(facade)
