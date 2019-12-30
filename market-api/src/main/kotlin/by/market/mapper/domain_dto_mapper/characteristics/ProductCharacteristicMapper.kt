package by.market.mapper.domain_dto_mapper.characteristics

import by.market.domain.characteristics.ProductCharacteristic
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.dto.characteristics.ProductCharacteristicFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductCharacteristicMapper : IMapstructMapper<ProductCharacteristicFrontEnd, ProductCharacteristic>
