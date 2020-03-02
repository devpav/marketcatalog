package by.market.mapper.domain_dto_mapper.product

import by.market.domain.product.ProductJalousie
import by.market.dto.product.ProductJalousieDTO
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductJalosieMapper : AbstractProductMapper<ProductJalousieDTO, ProductJalousie>
