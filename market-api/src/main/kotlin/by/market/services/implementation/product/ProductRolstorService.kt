package by.market.services.implementation.product

import by.market.domain.product.ProductRolstor
import by.market.repository.product.ProductRolstorRepository
import by.market.services.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductRolstorService(repository: ProductRolstorRepository)
    : BaseProductService<ProductRolstor, ProductRolstorRepository>(repository)
