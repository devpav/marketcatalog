package by.market.mapper.domain_dto_mapper.characteristics.single

import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.front_end.characteristics.single.StringFrontEndCharacteristic
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface StringCharacteristicMapper : IMapstructMapper<StringFrontEndCharacteristic, StringCharacteristic>
