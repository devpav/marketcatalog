package by.market.dto.system

import by.market.domain.system.ProductType
import by.market.repository.product.ProductTypeRepository
import org.springframework.stereotype.Service

@Service
class ProductTypeService(repository: ProductTypeRepository)
    : BaseSystemCharacteristicService<ProductType, ProductTypeRepository>(repository)
