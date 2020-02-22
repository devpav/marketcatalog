package by.market.core.facade.system

import by.market.core.facade.BaseSystemFacade
import by.market.domain.system.ProductType
import by.market.dto.system.ProductTypeService
import by.market.mapper.domain_dto_mapper.system.ProductTypeMapper
import by.market.mapper.dto.system.ProductTypeDTO
import org.springframework.stereotype.Component

@Component
class ProductTypeFacade(
        productTypeService: ProductTypeService,
        productTypeMapper: ProductTypeMapper
) : BaseSystemFacade<ProductTypeDTO, ProductType, ProductTypeService>(productTypeService, productTypeMapper)
