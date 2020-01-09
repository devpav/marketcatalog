package by.market.facade.product

import by.market.domain.product.ProductJalosie
import by.market.domain.system.Category
import by.market.facade.BaseProductFacade
import by.market.mapper.IMapstructMapper
import by.market.mapper.domain_dto_mapper.product.ProductJalosieMapper
import by.market.mapper.dto.product.ProductJalosieFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.services.implementation.product.ProductJalosieService
import org.springframework.stereotype.Component

@Component
class ProductJalosieFacade(
        productJalosieService: ProductJalosieService,
        productJalosieMapper: ProductJalosieMapper,
        categoryMapper: IMapstructMapper<CategoryFrontEnd, Category>
): BaseProductFacade<ProductJalosieFrontEnd, ProductJalosie>(productJalosieService,
        productJalosieMapper,
        categoryMapper)
