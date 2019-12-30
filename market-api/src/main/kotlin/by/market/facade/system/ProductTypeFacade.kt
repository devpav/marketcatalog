package by.market.facade.system

import by.market.domain.system.ProductType
import by.market.facade.AbstractFacade
import by.market.mapper.domain_dto_mapper.system.ProductTypeMapper
import by.market.mapper.dto.system.ProductTypeFrontEnd
import by.market.services.system.ProductTypeService
import org.springframework.stereotype.Component

@Component
class ProductTypeFacade(
        private val productTypeService: ProductTypeService,
        private val productTypeMapper: ProductTypeMapper
) : AbstractFacade<ProductTypeFrontEnd, ProductType>(productTypeService, productTypeMapper)