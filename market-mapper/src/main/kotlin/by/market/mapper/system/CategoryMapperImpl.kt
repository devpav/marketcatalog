package by.market.mapper.system

import by.market.domain.system.Category
import by.market.dto.system.CategoryDTO
import org.springframework.stereotype.Component

@Component
open class CategoryMapperImpl : CategoryMapper {

    override fun to(e: Category): CategoryDTO {
        val category = CategoryDTO()

        category.image = e.image
        category.parent = e.parentCategory?.id
        category.systemName = e.systemName
        category.title = e.title
        category.id = e.id

        return category
    }

    override fun to(e: Collection<Category>): Collection<CategoryDTO> {
        return e.map { to(it) }
    }

    override fun from(d: CategoryDTO): Category {
        val category = Category()

        category.image = d.image
        category.title = d.title
        category.systemName = d.systemName
        category.id = d.id

        if (d.parent !== null) {
            val parent = Category()
            parent.id = d.parent

            category.parentCategory = parent
        }

        return category
    }

    override fun from(d: Collection<CategoryDTO>): Collection<Category> {
        return d.map { from(it) }
    }

}