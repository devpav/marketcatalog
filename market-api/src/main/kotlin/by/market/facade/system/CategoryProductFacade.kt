package by.market.facade.system

import by.market.domain.system.Category
import by.market.facade.BaseSystemFacade
import by.market.mapper.domain_dto_mapper.system.CategoryMapper
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.services.system.CategoryService
import org.springframework.stereotype.Component

@Component
class CategoryProductFacade(
        categoryService: CategoryService,
        categoryMapper: CategoryMapper
) : BaseSystemFacade<CategoryFrontEnd, Category>(categoryService, categoryMapper)
