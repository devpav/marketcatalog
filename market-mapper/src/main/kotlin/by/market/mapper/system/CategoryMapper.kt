package by.market.mapper.system

import by.market.domain.system.Category
import by.market.dto.system.CategoryDTO
import by.market.mapper.IMapstructMapper
import org.mapstruct.Mapping

interface CategoryMapper : IMapstructMapper<CategoryDTO, Category> {

    @Mapping(source = "parentCategory.id", target = "parent")
    override fun to(e: Category): CategoryDTO

    override fun from(d: CategoryDTO): Category
}
