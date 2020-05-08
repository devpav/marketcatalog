package by.market.facade.impl

import by.market.domain.Product
import by.market.dto.product.ProductDTO
import by.market.mapper.ProductMapper
import by.market.services.impl.ProductService
import org.springframework.stereotype.Component

@Component
class ProductFacade (productService: ProductService, productMapper: ProductMapper)
    : BaseProductFacade<ProductDTO, Product>(productService, productMapper)
