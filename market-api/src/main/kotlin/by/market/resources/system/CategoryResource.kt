package by.market.resources.system

import by.market.core.facade.system.CategoryProductFacade
import by.market.dto.system.CategoryDTO
import by.market.resources.AbstractResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class CategoryResource(facade: CategoryProductFacade) : AbstractResource<CategoryDTO>(facade) {

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<Page<CategoryDTO>> {
        return super.findAll(pageable)
    }

}
