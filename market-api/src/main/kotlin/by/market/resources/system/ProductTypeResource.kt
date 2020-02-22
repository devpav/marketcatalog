package by.market.resources.system

import by.market.core.facade.system.ProductTypeFacade
import by.market.mapper.dto.system.ProductTypeDTO
import by.market.resources.AbstractResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product-type")
class ProductTypeResource(facade: ProductTypeFacade) : AbstractResource<ProductTypeDTO>(facade)
