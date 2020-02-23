package by.market.mapper.domain_dto_mapper.system

import by.market.domain.system.DataType
import by.market.dto.system.DataTypeDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface DataTypeMapper : IMapstructMapper<DataTypeDTO, DataType>
