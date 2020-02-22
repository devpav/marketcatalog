package by.market.core.facade.product

import by.market.core.facade.BaseProductFacade
import by.market.domain.product.ProductAccessory
import by.market.domain.system.Category
import by.market.dto.product.ProductAccessoryDTO
import by.market.dto.product.ProductAccessoryService
import by.market.dto.system.CategoryDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.domain_dto_mapper.product.ProductAccessoryMapper
import org.springframework.stereotype.Component

@Component
class ProductAccessoryFacade (
        productAccessoryService: ProductAccessoryService,
        productAccessoryMapper: ProductAccessoryMapper,
        categoryMapper: IMapstructMapper<CategoryDTO, Category>
): BaseProductFacade<ProductAccessoryDTO, ProductAccessory>(
        productAccessoryService,
        productAccessoryMapper,
        categoryMapper)
