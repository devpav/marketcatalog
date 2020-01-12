package by.market.mapper.domain_dto_mapper.characteristics.single

import by.market.domain.characteristics.single.StringCharacteristic
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.dto.characteristics.single.StringFrontEndCharacteristic
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface StringCharacteristicMapper : IMapstructMapper<StringFrontEndCharacteristic, StringCharacteristic>
