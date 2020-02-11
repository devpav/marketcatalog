package by.market.services.implementation.product

import by.market.core.Constant
import by.market.domain.product.ProductJalousie
import by.market.domain.system.EntityMetadata
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.product.ProductJalousieRepository
import by.market.repository.system.EntityMetadataRepository
import by.market.services.BaseProductService
import org.springframework.stereotype.Service

@Service
class ProductJalousieService(repository: ProductJalousieRepository,
                             stringSingleCharacteristicRepository: StringSingleCharacteristicRepository,
                             doubleSingleCharacteristicRepository: DoubleSingleCharacteristicRepository,
                             private val entityMetadataRepository: EntityMetadataRepository)
    : BaseProductService<ProductJalousie, ProductJalousieRepository>(repository,
        stringSingleCharacteristicRepository,
        doubleSingleCharacteristicRepository){
    override fun getEntityMetadata(): EntityMetadata {
        return entityMetadataRepository.findByTableName(Constant.EntityMetadata.Jalousie)
    }
}
