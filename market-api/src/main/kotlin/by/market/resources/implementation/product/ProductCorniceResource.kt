package by.market.resources.implementation.product

import by.market.facade.product.ProductCorniceFacade
import by.market.mapper.dto.product.ProductCorniceFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.BaseProductResource
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cornice-product")
class ProductCorniceResource(facade: ProductCorniceFacade)
    : BaseProductResource<ProductCorniceFacade, ProductCorniceFrontEnd>(facade) {

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<ProductCorniceFrontEnd>> {
        return super.findAll(pageable)
    }

    @GetMapping
    override fun findByCategory(category: CategoryFrontEnd): ResponseEntity<MutableList<ProductCorniceFrontEnd>> {
        return super.findByCategory(category)
    }
}
