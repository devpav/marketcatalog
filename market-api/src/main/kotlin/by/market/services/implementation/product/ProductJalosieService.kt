package by.market.services.implementation.product

import by.market.domain.product.ProductJalosie
import by.market.repository.product.ProductJalosieRepository
import by.market.services.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductJalosieService(repository: ProductJalosieRepository)
    : BaseProductService<ProductJalosie, ProductJalosieRepository>(repository)
