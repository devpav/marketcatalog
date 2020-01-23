package by.market.services.system

import by.market.domain.system.Category
import by.market.repository.system.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(repository: CategoryRepository)
    : BaseSystemCharacteristicService<Category, CategoryRepository>(repository){
    fun findAllByParentCategory(category: Category): List<Category> = rep.findAllByParentCategory(category)
}
