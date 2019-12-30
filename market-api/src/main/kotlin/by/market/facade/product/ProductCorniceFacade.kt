package by.market.facade.product

import by.market.domain.product.ProductCornice
import by.market.facade.AbstractFacade
import by.market.mapper.domain_dto_mapper.product.ProductCorniceMapper
import by.market.mapper.dto.product.ProductCorniceFrontEnd
import by.market.services.implementation.product.ProductCorniceService
import org.springframework.stereotype.Component

@Component
class ProductCorniceFacade(private val productCorniceService: ProductCorniceService,
                           private val productCorniceMapper: ProductCorniceMapper)
    : AbstractFacade<ProductCorniceFrontEnd, ProductCornice>(productCorniceService, productCorniceMapper)
