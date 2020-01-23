package by.market.facade.system

import by.market.domain.system.ProductType
import by.market.facade.BaseSystemFacade
import by.market.mapper.domain_dto_mapper.system.ProductTypeMapper
import by.market.mapper.dto.system.ProductTypeFrontEnd
import by.market.services.system.ProductTypeService
import org.springframework.stereotype.Component

@Component
class ProductTypeFacade(
        productTypeService: ProductTypeService,
        productTypeMapper: ProductTypeMapper
) : BaseSystemFacade<ProductTypeFrontEnd, ProductType, ProductTypeService>(productTypeService, productTypeMapper)
