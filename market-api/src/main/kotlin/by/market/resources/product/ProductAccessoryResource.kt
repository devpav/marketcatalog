package by.market.resources.product

import by.market.core.facade.product.ProductAccessoryFacade
import by.market.dto.product.ProductAccessoryDTO
import by.market.resources.BaseProductResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/accessory-product")
class ProductAccessoryResource(facade: ProductAccessoryFacade) : BaseProductResource<ProductAccessoryDTO>(facade)
