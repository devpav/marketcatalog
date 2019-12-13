package by.market.services.implementation.product

import by.market.domain.product.ProductCornice
import by.market.repository.product.ProductCorniceRepository
import by.market.services.implementation.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductCorniceService(repository: ProductCorniceRepository)
    : BaseProductService<ProductCornice, ProductCorniceRepository>(repository)
