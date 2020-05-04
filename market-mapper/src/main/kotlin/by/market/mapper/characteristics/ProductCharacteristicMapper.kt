package by.market.mapper.characteristics

import by.market.domain.characteristics.Characteristic
import by.market.dto.characteristics.ProductCharacteristicDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.system.DataTypeMapper
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class, uses = [ DataTypeMapper::class ])
interface ProductCharacteristicMapper : IMapstructMapper<ProductCharacteristicDTO, Characteristic>
