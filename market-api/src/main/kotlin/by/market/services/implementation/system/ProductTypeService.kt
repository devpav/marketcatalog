package by.market.services.implementation.system

import by.market.domain.system.ProductType
import by.market.repository.product.ProductTypeRepository
import by.market.services.implementation.BaseService
import org.springframework.stereotype.Service

@Service
class ProductTypeService(repository: ProductTypeRepository)
    : BaseService<ProductType, ProductTypeRepository>(repository)
