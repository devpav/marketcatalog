package by.market.mapper.domain_dto_mapper.product

import by.market.domain.product.ProductRolstor
import by.market.mapper.MapperConfig
import by.market.mapper.dto.product.ProductRolstorFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductRolstorMapper : AbstractProductMapper<ProductRolstorFrontEnd, ProductRolstor>
