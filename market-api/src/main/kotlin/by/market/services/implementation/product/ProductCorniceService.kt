package by.market.services.implementation.product

import by.market.domain.product.ProductCornice
import by.market.domain.system.EntityMetadata
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
                            private val entityMetadataRepository: EntityMetadataRepository)
    : BaseProductService<ProductCornice, ProductCorniceRepository>(repository,
        stringSingleCharacteristicRepository,
        doubleSingleCharacteristicRepository) {
    override fun getEntityMetadata(): EntityMetadata {
        return entityMetadataRepository.findByTableName("cornice")
    }
}
