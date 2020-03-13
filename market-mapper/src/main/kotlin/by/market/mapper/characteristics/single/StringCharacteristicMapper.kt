package by.market.mapper.characteristics.single

import by.market.domain.characteristics.single.StringCharacteristic
import by.market.dto.characteristics.StringCharacteristicDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface StringCharacteristicMapper : IMapstructMapper<StringCharacteristicDTO, StringCharacteristic>
