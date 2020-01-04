package by.market.resources.implementation.product

import by.market.facade.product.ProductJalosieFacade
import by.market.mapper.dto.product.ProductJalosieFrontEnd
import by.market.resources.BaseProductResource
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/jalosie-product")
class ProductJalosieResource(facade: ProductJalosieFacade)
    : BaseProductResource<ProductJalosieFacade, ProductJalosieFrontEnd>(facade) {

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<ProductJalosieFrontEnd>> {
        return super.findAll(pageable)
    }

}