package by.market.dto.product

import by.market.core.Constant
import by.market.domain.product.ProductCornice
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.product.ProductCorniceRepository
import by.market.repository.system.EntityMetadataRepository
import by.market.services.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductCorniceService(repository: ProductCorniceRepository,
                            stringSingleCharacteristicRepository: StringSingleCharacteristicRepository,
                            doubleSingleCharacteristicRepository: DoubleSingleCharacteristicRepository,
                            entityMetadataRepository: EntityMetadataRepository)
    : BaseProductService<ProductCornice, ProductCorniceRepository>(repository,
        stringSingleCharacteristicRepository,
        doubleSingleCharacteristicRepository,
        entityMetadataRepository,
        Constant.EntityMetadata.Cornice) {
}
