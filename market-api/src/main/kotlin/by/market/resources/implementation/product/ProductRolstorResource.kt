package by.market.resources.implementation.product

import by.market.facade.product.ProductRolstorFacade
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.product.ProductRolstorFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.BaseProductResource
import by.market.services.filter.model.ProductFilter
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/rolstor-product")
class ProductRolstorResource(facade: ProductRolstorFacade)
    : BaseProductResource<ProductRolstorFacade, ProductRolstorFrontEnd>(facade) {

    @GetMapping("/{id}")
    override fun findById(@PathVariable("id") id: UUID): ResponseEntity<ProductRolstorFrontEnd> {
        return super.findById(id)
    }

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<ProductRolstorFrontEnd>> {
        return super.findAll(pageable)
    }

    @GetMapping("/category")
    override fun findByCategory(category: CategoryFrontEnd): ResponseEntity<MutableList<ProductRolstorFrontEnd>> {
        return super.findByCategory(category)
    }

    @GetMapping("/characteristic")
    override fun findCharacteristic(product: ProductRolstorFrontEnd): ResponseEntity<FrontEndCharacteristicPair> {
        return super.findCharacteristic(product)
    }

    @GetMapping(value = ["/findByCategories/{categories}"])
    override fun findByCategories(@PathVariable("categories") categories: List<CategoryFrontEnd>): ResponseEntity<MutableList<ProductRolstorFrontEnd>> {
        return super.findByCategories(categories)
    }

    @PostMapping(value = ["/filter"])
    override fun findByFilter(@RequestBody productFilter: ProductFilter): ResponseEntity<MutableList<ProductRolstorFrontEnd>> {
        return super.findByFilter(productFilter)
    }

    @GetMapping("/count")
    override fun count(): ResponseEntity<Long> {
        return super.count()
    }
}
