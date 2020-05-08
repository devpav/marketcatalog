package by.market.mapper;

import by.market.domain.Product;
import by.market.dto.product.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface ProductMapper extends MapstructMapper<ProductDTO, Product> {

    @Override
    @Mapping(source = "category.id", target = "category")
    ProductDTO toMap(Product product);

    @Override
    @Mapping(source = "category", target = "category.id")
    Product fromMap(ProductDTO productDTO);

}
