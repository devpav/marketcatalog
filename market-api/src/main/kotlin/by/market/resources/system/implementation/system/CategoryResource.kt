package by.market.resources.system.implementation.system

import by.market.domain.system.Category
import by.market.resources.system.implementation.BaseMutableResource
import by.market.services.implementation.system.CategoryService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class CategoryResource(service: CategoryService): BaseMutableResource<CategoryService, Category>(service)
