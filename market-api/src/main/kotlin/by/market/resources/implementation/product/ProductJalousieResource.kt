package by.market.resources.implementation.product

import by.market.facade.product.ProductJalousieFacade
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.product.ProductJalousieFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.BaseProductResource
import by.market.services.filter.model.ProductFilter
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/jalousie-product")
class ProductJalousieResource(facade: ProductJalousieFacade)
    : BaseProductResource<ProductJalousieFacade, ProductJalousieFrontEnd>(facade) {

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<ProductJalousieFrontEnd>> {
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
