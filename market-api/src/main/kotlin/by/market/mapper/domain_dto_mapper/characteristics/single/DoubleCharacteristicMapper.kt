package by.market.mapper.domain_dto_mapper.characteristics.single

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.dto.characteristics.single.DoubleFrontEndCharacteristic
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface DoubleCharacteristicMapper : IMapstructMapper<DoubleFrontEndCharacteristic, DoubleCharacteristic>
