package by.market.mapper.product

import by.market.domain.Product
import by.market.dto.product.ProductDTO
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ProductMapper : AbstractProductMapper<ProductDTO, Product>
