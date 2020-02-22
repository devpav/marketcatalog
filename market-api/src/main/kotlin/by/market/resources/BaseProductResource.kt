package by.market.resources

import by.market.ProductFilter
import by.market.core.facade.IProductFacade
import by.market.mapper.dto.AbstractFrontEndProduct
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.system.CategoryFrontEnd
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

open class BaseProductResource<TFacade : IProductFacade<TDto>, TDto: AbstractFrontEndProduct>(service: TFacade)
    : BaseMutableResource<TDto, TFacade>(service) {

    @GetMapping(value = ["/findByCategory/{category}"])
    open fun findByCategory(@PathVariable("category")  category: CategoryFrontEnd): ResponseEntity<MutableList<TDto>> {
        return ResponseEntity.ok(service.findByCategory(category))
    }

    @GetMapping(value = ["/findByCategories/{categories}"])
    open fun findByCategories(@PathVariable("categories")  categories: List<CategoryFrontEnd>): ResponseEntity<MutableList<TDto>> {
        val res = categories.mapNotNull { findByCategory(it).body }.flatten().toMutableList()
        return ResponseEntity.ok(res)
    }

    @GetMapping(value = ["/findCharacteristic/{product}"])
    open fun findCharacteristic(@PathVariable("product") product: TDto): ResponseEntity<FrontEndCharacteristicPair> {
        return ResponseEntity.ok(service.findCharacteristicByProduct(product))
    }

    open fun findByFilter(productFilter: ProductFilter): ResponseEntity<MutableList<TDto>> {
        return ResponseEntity.ok(service.findByFilter(productFilter))
    }
}
