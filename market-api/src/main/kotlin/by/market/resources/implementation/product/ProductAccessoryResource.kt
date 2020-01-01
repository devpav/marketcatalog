package by.market.resources.implementation.product

import by.market.facade.product.ProductAccessoryFacade
import by.market.mapper.dto.product.ProductAccessoryFrontEnd
import by.market.resources.BaseProductResource
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/accessory-product")
class ProductAccessoryResource(facade: ProductAccessoryFacade)
    : BaseProductResource<ProductAccessoryFacade, ProductAccessoryFrontEnd>(facade) {

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<ProductAccessoryFrontEnd>> {
        return super.findAll(pageable)
    }

}

