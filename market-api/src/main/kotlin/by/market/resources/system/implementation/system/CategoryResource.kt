package by.market.resources.system.implementation.system

import by.market.facade.system.CategoryProductFacade
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.system.implementation.BaseMutableResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class CategoryResource(facade: CategoryProductFacade)
    : BaseMutableResource<CategoryFrontEnd, CategoryProductFacade>(facade)
