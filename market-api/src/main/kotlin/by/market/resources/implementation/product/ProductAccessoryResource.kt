package by.market.resources.implementation.product

import by.market.facade.product.ProductAccessoryFacade
import by.market.mapper.dto.ProductFilterFrontEnd
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.product.ProductAccessoryFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.BaseProductResource
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @GetMapping("/category")
    override fun findByCategory(category: CategoryFrontEnd): ResponseEntity<MutableList<ProductAccessoryFrontEnd>> {
        return super.findByCategory(category)
    }

    @GetMapping("/characteristic")
    override fun findCharacteristic(product: ProductAccessoryFrontEnd): ResponseEntity<FrontEndCharacteristicPair> {
        return super.findCharacteristic(product)
    }

    @GetMapping(value = ["/findByCategories/{categories}"])
    override fun findByCategories(@PathVariable("categories") categories: List<CategoryFrontEnd>): ResponseEntity<MutableList<ProductAccessoryFrontEnd>> {
        return super.findByCategories(categories)
    }

    @GetMapping(value = ["/findByFilter/{filter}"])
    override fun findByFilter(@PathVariable("filter") filter: ProductFilterFrontEnd): ResponseEntity<MutableList<ProductAccessoryFrontEnd>> {
        return super.findByFilter(filter)
    }

    @GetMapping("/count")
    override fun count(): ResponseEntity<Long> {
        return super.count()
    }
}
