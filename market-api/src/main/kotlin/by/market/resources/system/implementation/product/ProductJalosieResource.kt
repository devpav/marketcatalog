package by.market.resources.system.implementation.product

import by.market.domain.product.ProductJalosie
import by.market.resources.system.implementation.BaseProductResource
import by.market.services.implementation.product.ProductJalosieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/jalosie-product")
class ProductJalosieResource(service: ProductJalosieService)
    : BaseProductResource<ProductJalosieService, ProductJalosie>(service) {
    @GetMapping
    override fun findAll(): ResponseEntity<MutableList<ProductJalosie>> {
        return super.findAll()
    }
}
