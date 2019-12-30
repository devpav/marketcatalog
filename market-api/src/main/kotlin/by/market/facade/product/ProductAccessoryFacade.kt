package by.market.facade.product

import by.market.domain.product.ProductAccessory
import by.market.facade.AbstractFacade
import by.market.mapper.domain_dto_mapper.product.ProductAccessoryMapper
import by.market.mapper.dto.product.ProductAccessoryFrontEnd
import by.market.services.implementation.product.ProductAccessoryService
import org.springframework.stereotype.Component

@Component
class ProductAccessoryFacade (
        private val productAccessoryService: ProductAccessoryService,
        private val productAccessoryMapper: ProductAccessoryMapper
): AbstractFacade<ProductAccessoryFrontEnd, ProductAccessory>(productAccessoryService, productAccessoryMapper)
