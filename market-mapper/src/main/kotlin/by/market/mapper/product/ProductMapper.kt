package by.market.mapper.product

import by.market.domain.Product
import by.market.dto.product.ProductDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(config = MapperConfig::class)
interface ProductMapper : IMapstructMapper<ProductDTO, Product> {

    @Mapping(source = "category.id", target = "category")
    override fun to(e: Product): ProductDTO

    @Mapping(source = "category", target = "category.id")
    override fun from(d: ProductDTO): Product

}
