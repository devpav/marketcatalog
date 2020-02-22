package by.market.resources.product

import by.market.core.facade.product.ProductRolstorFacade
import by.market.dto.product.ProductRolstorDTO
import by.market.resources.BaseProductResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rolstor-product")
class ProductRolstorResource(facade: ProductRolstorFacade) : BaseProductResource<ProductRolstorDTO>(facade) {

}
