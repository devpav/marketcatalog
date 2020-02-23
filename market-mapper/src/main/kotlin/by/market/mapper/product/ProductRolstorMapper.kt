package by.market.mapper.domain_dto_mapper.product

import by.market.domain.product.ProductRolstor
import by.market.dto.product.ProductRolstorDTO
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductRolstorMapper : AbstractProductMapper<ProductRolstorDTO, ProductRolstor>
