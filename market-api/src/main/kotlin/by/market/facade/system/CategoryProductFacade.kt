package by.market.facade.system

import by.market.domain.system.Category
import by.market.facade.AbstractFacade
import by.market.mapper.domain_dto_mapper.system.CategoryMapper
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.services.system.CategoryService
import org.springframework.stereotype.Component

@Component
class CategoryProductFacade(
        private val categoryService: CategoryService,
        private val categoryMapper: CategoryMapper
) : AbstractFacade<CategoryFrontEnd, Category>(categoryService, categoryMapper)