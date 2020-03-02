package by.market.mapper.domain_dto_mapper.product

import by.market.domain.product.ProductAccessory
import by.market.dto.product.ProductAccessoryDTO
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductAccessoryMapper : AbstractProductMapper<ProductAccessoryDTO, ProductAccessory>
