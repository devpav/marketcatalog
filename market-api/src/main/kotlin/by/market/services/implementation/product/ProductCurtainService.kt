package by.market.services.implementation.product

import by.market.domain.product.ProductCurtain
import by.market.repository.product.ProductCurtainRepository
import by.market.services.implementation.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductCurtainService(repository: ProductCurtainRepository)
    : BaseProductService<ProductCurtain, ProductCurtainRepository>(repository)
