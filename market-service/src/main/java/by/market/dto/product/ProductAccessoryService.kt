package by.market.dto.product

import by.market.core.Constant
import by.market.domain.product.ProductAccessory
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.product.ProductAccessoryRepository
import by.market.repository.system.EntityMetadataRepository
import by.market.services.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductAccessoryService(repository: ProductAccessoryRepository,
                              stringSingleCharacteristicRepository: StringSingleCharacteristicRepository,
                              doubleSingleCharacteristicRepository: DoubleSingleCharacteristicRepository,
                              entityMetadataRepository: EntityMetadataRepository)
    : BaseProductService<ProductAccessory, ProductAccessoryRepository>(repository,
        stringSingleCharacteristicRepository,
        doubleSingleCharacteristicRepository,
        entityMetadataRepository,
        Constant.EntityMetadata.Accessory) {
}
