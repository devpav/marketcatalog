package by.market.mapper.domain_dto_mapper.system

import by.market.domain.system.ProductType
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.dto.system.ProductTypeDTO
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductTypeMapper : IMapstructMapper<ProductTypeDTO, ProductType>
