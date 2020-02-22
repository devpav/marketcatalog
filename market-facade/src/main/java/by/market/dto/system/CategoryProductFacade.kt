package by.market.core.facade.system

import by.market.core.facade.BaseSystemFacade
import by.market.domain.system.Category
import by.market.dto.system.CategoryDTO
import by.market.dto.system.CategoryService
import by.market.mapper.domain_dto_mapper.system.CategoryMapper
import org.springframework.stereotype.Component

@Component
class CategoryProductFacade(
        categoryService: CategoryService,
        categoryMapper: CategoryMapper
) : BaseSystemFacade<CategoryDTO, Category, CategoryService>(categoryService, categoryMapper) {
    fun findByParent(category: CategoryDTO): Collection<CategoryDTO> {
        val databaseCategory = mapper.from(category)
        return mapper.to(entityService.findAllByParentCategory(databaseCategory))
    }
}
