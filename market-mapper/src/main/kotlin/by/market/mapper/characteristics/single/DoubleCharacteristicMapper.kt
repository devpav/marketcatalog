package by.market.mapper.characteristics.single

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.dto.characteristics.DoubleCharacteristicDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.characteristics.ProductCharacteristicMapper
import by.market.mapper.product.ProductMapper
import by.market.mapper.system.EntityMetadataMapper
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class, uses = [
    ProductCharacteristicMapper::class,
    EntityMetadataMapper::class,
    ProductMapper::class
])
interface DoubleCharacteristicMapper : IMapstructMapper<DoubleCharacteristicDTO, DoubleCharacteristic>
