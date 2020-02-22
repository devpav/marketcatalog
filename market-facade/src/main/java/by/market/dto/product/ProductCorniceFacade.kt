package by.market.core.facade.product

import by.market.core.facade.BaseProductFacade
import by.market.domain.product.ProductCornice
import by.market.domain.system.Category
import by.market.dto.product.ProductCorniceDTO
import by.market.dto.product.ProductCorniceService
import by.market.dto.system.CategoryDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.domain_dto_mapper.product.ProductCorniceMapper
import org.springframework.stereotype.Component

@Component
class ProductCorniceFacade(productCorniceService: ProductCorniceService,
                           productCorniceMapper: ProductCorniceMapper,
                           categoryMapper: IMapstructMapper<CategoryDTO, Category>)
    : BaseProductFacade<ProductCorniceDTO, ProductCornice>(productCorniceService,
        productCorniceMapper,
        categoryMapper)
