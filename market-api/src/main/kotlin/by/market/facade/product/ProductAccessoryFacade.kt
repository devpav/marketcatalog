package by.market.facade.product

import by.market.domain.product.ProductAccessory
import by.market.domain.system.Category
import by.market.facade.BaseProductFacade
import by.market.mapper.IMapstructMapper
import by.market.mapper.domain_dto_mapper.product.ProductAccessoryMapper
import by.market.mapper.dto.product.ProductAccessoryFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.services.implementation.product.ProductAccessoryService
import org.springframework.stereotype.Component

@Component
class ProductAccessoryFacade (
        productAccessoryService: ProductAccessoryService,
        productAccessoryMapper: ProductAccessoryMapper,
        categoryMapper: IMapstructMapper<CategoryFrontEnd, Category>
): BaseProductFacade<ProductAccessoryFrontEnd, ProductAccessory>(
        productAccessoryService,
        productAccessoryMapper,
        categoryMapper)
