package by.market.mapper.domain_dto_mapper.product

import by.market.domain.product.ProductCornice
import by.market.mapper.MapperConfig
import by.market.mapper.dto.product.ProductCorniceFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductCorniceMapper : AbstractProductMapper<ProductCorniceFrontEnd, ProductCornice>
