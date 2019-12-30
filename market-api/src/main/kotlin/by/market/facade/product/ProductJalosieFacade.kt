package by.market.facade.product

import by.market.domain.product.ProductJalosie
import by.market.facade.AbstractFacade
import by.market.mapper.domain_dto_mapper.product.ProductJalosieMapper
import by.market.mapper.dto.product.ProductJalosieFrontEnd
import by.market.services.implementation.product.ProductJalosieService
import org.springframework.stereotype.Component

@Component
class ProductJalosieFacade(
        private val productJalosieService: ProductJalosieService,
        private val productJalosieMapper: ProductJalosieMapper
): AbstractFacade<ProductJalosieFrontEnd, ProductJalosie>(productJalosieService, productJalosieMapper)
