package by.market.mapper.entity_metadata

import arrow.core.Option
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
            "accessory" -> Option.just(ProductType.Accessories)
            "cornice" -> Option.just(ProductType.Cornice)
            "jalosie" -> Option.just(ProductType.Jalosie)
            "rolstor" -> Option.just(ProductType.Rolstor)
            else -> Option.empty()
        }
    }

    override fun toFrom(to: ProductType): Option<EntityMetadata> {
        return when(to) {
            ProductType.Accessories -> Option.just(entityMetadataRepository.findByTableName("accessory"))
            ProductType.Cornice -> Option.just(entityMetadataRepository.findByTableName("cornice"))
            ProductType.Jalosie -> Option.just(entityMetadataRepository.findByTableName("jalosie"))
            ProductType.Rolstor -> Option.just(entityMetadataRepository.findByTableName("rolstor"))
        }
    }

}
