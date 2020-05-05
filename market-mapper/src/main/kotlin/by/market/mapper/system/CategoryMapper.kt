package by.market.mapper.system

import by.market.domain.system.Category
import by.market.dto.system.CategoryDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(config = MapperConfig::class)
interface CategoryMapper : IMapstructMapper<CategoryDTO, Category> {

    @Mappings(value = [
        Mapping(source = "parentCategory.id", target = "parent"),
        Mapping(source = "image", target = "image")
    ])
    override fun to(e: Category): CategoryDTO

    @InheritInverseConfiguration
    override fun from(d: CategoryDTO): Category

}
