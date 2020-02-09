package by.market.facade.product

import by.market.domain.product.ProductJalousie
import by.market.domain.system.Category
import by.market.facade.BaseProductFacade
import by.market.mapper.IMapstructMapper
import by.market.mapper.domain_dto_mapper.product.ProductJalosieMapper
import by.market.mapper.dto.product.ProductJalousieFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.services.implementation.product.ProductJalousieService
import org.springframework.stereotype.Component

@Component
class ProductJalousieFacade(
        productJalousieService: ProductJalousieService,
        productJalousieMapper: ProductJalosieMapper,
        categoryMapper: IMapstructMapper<CategoryFrontEnd, Category>
): BaseProductFacade<ProductJalousieFrontEnd, ProductJalousie>(productJalousieService,
        productJalousieMapper,
        categoryMapper)
