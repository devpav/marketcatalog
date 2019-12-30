package by.market.mapper.domain_dto_mapper.system

import by.market.domain.system.Category
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.dto.system.CategoryFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface CategoryMapper : IMapstructMapper<CategoryFrontEnd, Category>
