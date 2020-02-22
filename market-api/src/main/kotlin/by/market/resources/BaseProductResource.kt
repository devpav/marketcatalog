package by.market.resources

import by.market.ProductFilter
import by.market.dto.characteristics.CharacteristicPairDTO
import by.market.dto.system.CategoryDTO
import by.market.facade.IProductFacade
import by.market.mapper.dto.AbstractProductDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

open class BaseProductResource<TDto: AbstractProductDTO>(protected val productFacade: IProductFacade<TDto>) : AbstractResource<TDto>(productFacade) {

    @GetMapping("/category")
    open fun findByCategory(category: CategoryDTO): ResponseEntity<MutableList<TDto>> {
        return ResponseEntity.ok(productFacade.findByCategory(category))
    }

    @GetMapping("/categories")
    open fun findByCategories(categories: List<CategoryDTO>): ResponseEntity<MutableList<TDto>> {
        val res = categories.mapNotNull { findByCategory(it).body }.flatten().toMutableList()
        return ResponseEntity.ok(res)
    }

    @GetMapping("/characteristic")
    open fun findCharacteristic(product: TDto): ResponseEntity<CharacteristicPairDTO> {
        return ResponseEntity.ok(productFacade.findCharacteristicByProduct(product))
    }

    @PostMapping("/filter")
    open fun findByFilter(productFilter: ProductFilter): ResponseEntity<MutableList<TDto>> {
        return ResponseEntity.ok(productFacade.findByFilter(productFilter))
    }

}
