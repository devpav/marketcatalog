package by.market.resources.implementation.product

import by.market.ProductFilter
import by.market.core.facade.product.ProductJalousieFacade
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.product.ProductJalousieFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.BaseProductResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/jalousie-product")
class ProductJalousieResource(facade: ProductJalousieFacade)
    : BaseProductResource<ProductJalousieFacade, ProductJalousieFrontEnd>(facade) {

    @GetMapping("/{id}")
    override fun findById(@PathVariable("id") id: UUID): ResponseEntity<Optional<ProductJalousieFrontEnd>> {
        return super.findById(id)
    }


    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<Page<ProductJalousieFrontEnd>> {
        return super.findAll(pageable)
    }

    @GetMapping("/category")
    override fun findByCategory(category: CategoryFrontEnd): ResponseEntity<MutableList<ProductJalousieFrontEnd>> {
        return super.findByCategory(category)
    }

    @GetMapping("/characteristic")
    override fun findCharacteristic(product: ProductJalousieFrontEnd): ResponseEntity<FrontEndCharacteristicPair> {
        return super.findCharacteristic(product)
    }

    @GetMapping(value = ["/findByCategories/{categories}"])
    override fun findByCategories(@PathVariable("categories") categories: List<CategoryFrontEnd>): ResponseEntity<MutableList<ProductJalousieFrontEnd>> {
        return super.findByCategories(categories)
    }

    @PostMapping(value = ["/filter"])
    override fun findByFilter(@RequestBody productFilter: ProductFilter): ResponseEntity<MutableList<ProductJalousieFrontEnd>> {
        return super.findByFilter(productFilter)
    }

    @GetMapping("/count")
    override fun count(): ResponseEntity<Long> {
        return super.count()
    }
}
