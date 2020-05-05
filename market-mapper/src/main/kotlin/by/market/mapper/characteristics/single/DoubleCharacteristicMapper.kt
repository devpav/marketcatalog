package by.market.mapper.characteristics.single

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.dto.characteristics.DoubleCharacteristicDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface DoubleCharacteristicMapper : IMapstructMapper<DoubleCharacteristicDTO, DoubleCharacteristic>
