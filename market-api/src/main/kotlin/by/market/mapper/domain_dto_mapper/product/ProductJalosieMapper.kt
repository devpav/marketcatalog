package by.market.mapper.domain_dto_mapper.product

import by.market.domain.product.ProductJalousie
import by.market.mapper.MapperConfig
import by.market.mapper.dto.product.ProductJalousieFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductJalosieMapper : AbstractProductMapper<ProductJalousieFrontEnd, ProductJalousie>
