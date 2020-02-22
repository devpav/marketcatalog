package by.market.core.facade.product

import by.market.core.facade.BaseProductFacade
import by.market.domain.product.ProductJalousie
import by.market.domain.system.Category
import by.market.dto.product.ProductJalousieDTO
import by.market.dto.product.ProductJalousieService
import by.market.dto.system.CategoryDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.domain_dto_mapper.product.ProductJalosieMapper
import org.springframework.stereotype.Component

@Component
class ProductJalousieFacade(
        productJalousieService: ProductJalousieService,
        productJalousieMapper: ProductJalosieMapper,
        categoryMapper: IMapstructMapper<CategoryDTO, Category>
): BaseProductFacade<ProductJalousieDTO, ProductJalousie>(productJalousieService,
        productJalousieMapper,
        categoryMapper)
