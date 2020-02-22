package by.market.dto.product

import by.market.core.Constant
import by.market.domain.product.ProductRolstor
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
                           entityMetadataRepository: EntityMetadataRepository)
    : BaseProductService<ProductRolstor, ProductRolstorRepository>(repository,
        stringSingleCharacteristicRepository,
        doubleSingleCharacteristicRepository,
        entityMetadataRepository,
        Constant.EntityMetadata.Rolstor) {
}
