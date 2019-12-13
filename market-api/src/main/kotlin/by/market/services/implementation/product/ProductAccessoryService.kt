package by.market.services.implementation.product

import by.market.domain.product.ProductAccessory
import by.market.repository.product.ProductAccessoryRepository
import by.market.services.implementation.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductAccessoryService(repository: ProductAccessoryRepository)
    : BaseProductService<ProductAccessory, ProductAccessoryRepository>(repository) {

}
