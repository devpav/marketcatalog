package by.market.resources.implementation.system

import by.market.facade.system.CategoryProductFacade
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.BaseMutableResource
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class CategoryResource(facade: CategoryProductFacade) : BaseMutableResource<CategoryFrontEnd, CategoryProductFacade>(facade) {

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<CategoryFrontEnd>> {
        return super.findAll(pageable)
    }
}
