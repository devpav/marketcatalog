package by.market.services.implementation.product

import by.market.core.Constant
import by.market.domain.product.ProductRolstor
import by.market.domain.system.EntityMetadata
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.product.ProductRolstorRepository
import by.market.repository.system.EntityMetadataRepository
import by.market.services.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductRolstorService(repository: ProductRolstorRepository,
                            stringSingleCharacteristicRepository: StringSingleCharacteristicRepository,
                            doubleSingleCharacteristicRepository: DoubleSingleCharacteristicRepository,
                            private val entityMetadataRepository: EntityMetadataRepository)
    : BaseProductService<ProductRolstor, ProductRolstorRepository>(repository,
        stringSingleCharacteristicRepository,
        doubleSingleCharacteristicRepository) {
    override fun getEntityMetadata(): EntityMetadata {
        return entityMetadataRepository.findByTableName(Constant.EntityMetadata.Rolstor)
    }
}
