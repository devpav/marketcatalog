package by.market.mapper.domain_dto_mapper.system

import by.market.domain.system.Category
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.dto.system.CategoryFrontEnd
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(config = MapperConfig::class)
interface CategoryMapper : IMapstructMapper<CategoryFrontEnd, Category> {

    @Mapping(source = "parentCategory.id", target = "parent")
    override fun to(e: Category): CategoryFrontEnd

    @InheritInverseConfiguration
    override fun from(d: CategoryFrontEnd): Category

}
