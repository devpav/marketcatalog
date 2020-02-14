package by.market.resources.implementation.product

import by.market.facade.product.ProductCorniceFacade
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.product.ProductCorniceFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.BaseProductResource
import by.market.services.filter.model.ProductFilter
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/cornice-product")
class ProductCorniceResource(facade: ProductCorniceFacade)
    : BaseProductResource<ProductCorniceFacade, ProductCorniceFrontEnd>(facade) {

    @GetMapping("/{id}")
    override fun findById(@PathVariable("id") id: UUID): ResponseEntity<ProductCorniceFrontEnd> {
        return super.findById(id)
    }


    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<ProductCorniceFrontEnd>> {
        return super.findAll(pageable)
    }

    @GetMapping("/category")
    override fun findByCategory(category: CategoryFrontEnd): ResponseEntity<MutableList<ProductCorniceFrontEnd>> {
        return super.findByCategory(category)
    }

    @GetMapping("/characteristic")
    override fun findCharacteristic(product: ProductCorniceFrontEnd): ResponseEntity<FrontEndCharacteristicPair> {
        return super.findCharacteristic(product)
    }

    @GetMapping(value = ["/findByCategories/{categories}"])
    override fun findByCategories(@PathVariable("categories") categories: List<CategoryFrontEnd>): ResponseEntity<MutableList<ProductCorniceFrontEnd>> {
        return super.findByCategories(categories)
    }

    @PostMapping(value = ["/filter"])
    override fun findByFilter(@RequestBody productFilter: ProductFilter): ResponseEntity<MutableList<ProductCorniceFrontEnd>> {
        return super.findByFilter(productFilter)
    }

    @GetMapping("/count")
    override fun count(): ResponseEntity<Long> {
        return super.count()
    }

}
