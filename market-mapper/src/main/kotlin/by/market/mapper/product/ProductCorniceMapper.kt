package by.market.mapper.domain_dto_mapper.product

import by.market.domain.product.ProductCornice
import by.market.dto.product.ProductCorniceDTO
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductCorniceMapper : AbstractProductMapper<ProductCorniceDTO, ProductCornice>
