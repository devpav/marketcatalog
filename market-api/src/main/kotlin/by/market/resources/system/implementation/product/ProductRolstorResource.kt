package by.market.resources.system.implementation.product

import by.market.domain.product.ProductRolstor
import by.market.resources.system.implementation.BaseProductResource
import by.market.services.implementation.product.ProductRolstorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rolstor-product")
class ProductRolstorResource(service: ProductRolstorService)
    : BaseProductResource<ProductRolstorService, ProductRolstor>(service) {
    @GetMapping
    override fun findAll(): ResponseEntity<MutableList<ProductRolstor>> {
        return super.findAll()
    }
}
