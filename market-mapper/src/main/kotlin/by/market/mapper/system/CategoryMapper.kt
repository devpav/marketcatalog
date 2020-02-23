package by.market.mapper.domain_dto_mapper.system

import by.market.domain.system.Category
import by.market.dto.system.CategoryDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(config = MapperConfig::class)
interface CategoryMapper : IMapstructMapper<CategoryDTO, Category> {

    @Mapping(source = "parentCategory.id", target = "parent")
    override fun to(e: Category): CategoryDTO

    @InheritInverseConfiguration
    override fun from(d: CategoryDTO): Category

}
