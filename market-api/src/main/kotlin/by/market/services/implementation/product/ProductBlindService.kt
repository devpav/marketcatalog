package by.market.services.implementation.product

import by.market.domain.product.ProductBlind
import by.market.repository.product.ProductBlindRepository
import by.market.services.implementation.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductBlindService(repository: ProductBlindRepository)
    : BaseProductService<ProductBlind, ProductBlindRepository>(repository)
