package by.market.mapper.domain_dto_mapper.system

import by.market.domain.system.DataType
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.dto.system.DataTypeFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface DataTypeMapper : IMapstructMapper<DataTypeFrontEnd, DataType>
