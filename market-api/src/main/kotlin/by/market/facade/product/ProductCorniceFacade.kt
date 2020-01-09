package by.market.facade.product

import by.market.domain.product.ProductCornice
import by.market.domain.system.Category
import by.market.facade.BaseProductFacade
import by.market.mapper.IMapstructMapper
import by.market.mapper.domain_dto_mapper.product.ProductCorniceMapper
import by.market.mapper.dto.product.ProductCorniceFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.services.implementation.product.ProductCorniceService
import org.springframework.stereotype.Component

@Component
class ProductCorniceFacade(productCorniceService: ProductCorniceService,
                           productCorniceMapper: ProductCorniceMapper,
                           categoryMapper: IMapstructMapper<CategoryFrontEnd, Category>)
    : BaseProductFacade<ProductCorniceFrontEnd, ProductCornice>(productCorniceService,
        productCorniceMapper,
        categoryMapper)
