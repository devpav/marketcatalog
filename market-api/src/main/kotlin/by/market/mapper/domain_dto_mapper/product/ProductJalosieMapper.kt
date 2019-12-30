package by.market.mapper.domain_dto_mapper.product

import by.market.domain.product.ProductJalosie
import by.market.mapper.MapperConfig
import by.market.mapper.dto.product.ProductJalosieFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductJalosieMapper : AbstractProductMapper<ProductJalosieFrontEnd, ProductJalosie>
