package by.market.services.impl

import by.market.domain.nosql.TreeCategory
import by.market.domain.system.Category
import by.market.repository.system.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
open class CategoryService(val repository: CategoryRepository) : BaseSystemCharacteristicService<Category, CategoryRepository>(repository){

    fun findAllByParentCategory(category: Category): List<Category> = rep.findAllByParentCategory(category)

    fun countAllByParentCategory(category: Category): Long = rep.countAllByParentCategory(category)

    fun findRootCategory(idCategory: UUID): Category? {
        val category = rep.findById(idCategory)

        if (category.isPresent) {
            val currentCategory = category.get()
            val parentCategory = currentCategory.parentCategory

            if (parentCategory?.id == null || currentCategory.id == parentCategory.id)
                return currentCategory

            return findRootCategory(parentCategory.id!!)
        }

        return null
    }

    @Transactional(readOnly = true)
    open fun findTreeCategory(): MutableList<TreeCategory> {
        val categories = rep.findAllByParentCategoryIsNull();
        return categories.mapNotNull { buildRecursiveTree(it) }.toMutableList()
    }

    private fun buildRecursiveTree(category: Category): TreeCategory? {
        val id = category.id

        id ?: return null

        val foundOptionalCategory = repository.findById(id)

        if ( !foundOptionalCategory.isPresent ) {
            return null
        }

        val treeCategory: TreeCategory = TreeCategory()

        treeCategory.id = category.id
        treeCategory.title = category.title

        val optionalCategory = foundOptionalCategory.get()

        val subCategories: Set<Category>? = optionalCategory.subCategories

        val setSubCategories = subCategories ?: mutableSetOf()

        treeCategory.subcategory = setSubCategories.mapNotNull { buildRecursiveTree(it) }
                .toMutableList()

        return treeCategory
    }

}
