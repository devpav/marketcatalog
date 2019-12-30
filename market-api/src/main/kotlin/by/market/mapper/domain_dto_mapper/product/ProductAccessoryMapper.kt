package by.market.mapper.domain_dto_mapper.product

import by.market.domain.product.ProductAccessory
import by.market.mapper.MapperConfig
import by.market.mapper.dto.product.ProductAccessoryFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductAccessoryMapper : AbstractProductMapper<ProductAccessoryFrontEnd, ProductAccessory>
