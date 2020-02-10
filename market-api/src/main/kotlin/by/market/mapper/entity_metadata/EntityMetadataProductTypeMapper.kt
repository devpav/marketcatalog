package by.market.mapper.entity_metadata

import arrow.core.Option
import by.market.core.Constant
import by.market.core.IBiMapper
import by.market.core.ProductType
import by.market.domain.system.EntityMetadata
import by.market.repository.system.EntityMetadataRepository
import org.springframework.stereotype.Component

@Component
class EntityMetadataProductTypeMapper(private val entityMetadataRepository: EntityMetadataRepository)
    : IBiMapper<EntityMetadata, ProductType> {
    override fun fromTo(from: EntityMetadata): Option<ProductType> {
        return when(from.tableName) {
            Constant.EntityMetadata.Accessory -> Option.just(ProductType.Accessories)
            Constant.EntityMetadata.Cornice -> Option.just(ProductType.Cornice)
            Constant.EntityMetadata.Jalousie -> Option.just(ProductType.Jalousie)
            Constant.EntityMetadata.Rolstor -> Option.just(ProductType.Rolstor)
            else -> Option.empty()
        }
    }

    override fun toFrom(to: ProductType): Option<EntityMetadata> {
        return when(to) {
            ProductType.Accessories -> Option.just(entityMetadataRepository.findAccessory())
            ProductType.Cornice -> Option.just(entityMetadataRepository.findCornice())
            ProductType.Jalousie -> Option.just(entityMetadataRepository.findJalousie())
            ProductType.Rolstor -> Option.just(entityMetadataRepository.findRolstor())
        }
    }

}
