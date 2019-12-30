package by.market.facade.product

import by.market.domain.product.ProductRolstor
import by.market.facade.AbstractFacade
import by.market.mapper.domain_dto_mapper.product.ProductRolstorMapper
import by.market.mapper.dto.product.ProductRolstorFrontEnd
import by.market.services.implementation.product.ProductRolstorService
import org.springframework.stereotype.Component

@Component
class ProductRolstorFacade(
        private val productRolstorService: ProductRolstorService,
        private val productRolstorMapper: ProductRolstorMapper
) : AbstractFacade<ProductRolstorFrontEnd, ProductRolstor>(productRolstorService, productRolstorMapper)
