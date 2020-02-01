package by.market.mapper.entity_metadata

import arrow.core.Option
import by.market.core.IBiMapper
import by.market.domain.system.Category
import by.market.domain.system.EntityMetadata
import by.market.repository.system.CategoryRepository
import by.market.repository.system.EntityMetadataRepository
import org.springframework.stereotype.Component

@Component
class EntityMetadataProductCharacteristicMapper(private val categoryRep: CategoryRepository,
                                                private val entityMetadataRepository: EntityMetadataRepository)
    : IBiMapper<EntityMetadata, Category> {
    override fun fromTo(from: EntityMetadata): Option<Category> {
        return when(from.tableName) {
            "accessory", "luversa", "grips_holders_hooks", "magnetic_clips"
                -> Option.fromNullable(categoryRep.findBySystemName("accessory"))
            "cornice", "metallic", "plastic_ceilings", "wall_metal_plastic",
            "flexible", "accessories_for_ceiling", "metal_plastic_accessories", "accessories_for_metal"
                -> Option.fromNullable(categoryRep.findBySystemName("cornice"))
            "jalosie"
                -> Option.fromNullable(categoryRep.findBySystemName("jalousie"))
            "rolstor", "day_night", "standard", "in_box", "premium", "blackout"
                -> Option.fromNullable(categoryRep.findBySystemName("rolstor"))
            else -> Option.empty()
        }
    }

    override fun toFrom(to: Category): Option<EntityMetadata> {
        return when(to.systemName){
            "accessory" -> Option.fromNullable(entityMetadataRepository.findByTableName("accessory"))
            "cornice" -> Option.fromNullable(entityMetadataRepository.findByTableName("cornice"))
            "jalosie" -> Option.fromNullable(entityMetadataRepository.findByTableName("jalosie"))
            "rolstor" -> Option.fromNullable(entityMetadataRepository.findByTableName("rolstor"))
            else -> Option.empty()
        }
    }

}
