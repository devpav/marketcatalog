package by.market.resources.implementation.product

import by.market.facade.product.ProductRolstorFacade
import by.market.mapper.dto.product.ProductRolstorFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.BaseProductResource
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rolstor-product")
class ProductRolstorResource(facade: ProductRolstorFacade)
    : BaseProductResource<ProductRolstorFacade, ProductRolstorFrontEnd>(facade) {

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<ProductRolstorFrontEnd>> {
        return super.findAll(pageable)
    }

    @GetMapping
    override fun findByCategory(category: CategoryFrontEnd): ResponseEntity<MutableList<ProductRolstorFrontEnd>> {
        return super.findByCategory(category)
    }
}
