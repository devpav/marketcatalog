package by.market.mapper.domain_dto_mapper.characteristics.single

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.front_end.characteristics.single.DoubleFrontEndCharacteristic
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface DoubleCharacteristicMapper : IMapstructMapper<DoubleFrontEndCharacteristic, DoubleCharacteristic>
