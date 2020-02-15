package by.market.mapper.entity_metadata

import arrow.core.Option
import by.market.core.Constant
import by.market.core.IBiMapper
import by.market.domain.system.Category
import by.market.domain.system.EntityMetadata
import by.market.extension.findAccessory
import by.market.extension.findCornice
import by.market.extension.findJalousie
import by.market.extension.findRolstor
import by.market.repository.extension.findAccessory
import by.market.repository.extension.findCornice
import by.market.repository.extension.findJalousie
import by.market.repository.extension.findRolstor
import by.market.repository.system.CategoryRepository
import by.market.repository.system.EntityMetadataRepository
import org.springframework.stereotype.Component

@Component
class EntityMetadataProductCharacteristicMapper(private val categoryRep: CategoryRepository,
                                                private val entityMetadataRepository: EntityMetadataRepository)
    : IBiMapper<EntityMetadata, Category> {
    override fun fromTo(from: EntityMetadata): Option<Category> {
        return when(from.tableName) {
            Constant.Category.Accessory,
            Constant.Category.Luversa,
            Constant.Category.GripsHoldersHooks,
            Constant.Category.MagneticClips
                -> Option.fromNullable(categoryRep.findAccessory())

            Constant.Category.Cornice,
            Constant.Category.Metallic,
            Constant.Category.PlasticCeilings,
            Constant.Category.WallMetalPlastic,
            Constant.Category.Flexible,
            Constant.Category.AccessoriesForCeiling,
            Constant.Category.MetalPlasticAccessories,
            Constant.Category.AccessoriesForMetal
                -> Option.fromNullable(categoryRep.findCornice())

            Constant.Category.Jalousie
                -> Option.fromNullable(categoryRep.findJalousie())

            Constant.Category.Rolstor,
            Constant.Category.DayNight,
            Constant.Category.Standard,
            Constant.Category.InBox,
            Constant.Category.Premium,
            Constant.Category.Blackout
                -> Option.fromNullable(categoryRep.findRolstor())

            else
                -> Option.empty()
        }
    }

    override fun toFrom(to: Category): Option<EntityMetadata> {
        return when(to.systemName){
            Constant.EntityMetadata.Accessory-> Option.fromNullable(entityMetadataRepository.findAccessory())
            Constant.EntityMetadata.Cornice -> Option.fromNullable(entityMetadataRepository.findCornice())
            Constant.EntityMetadata.Jalousie -> Option.fromNullable(entityMetadataRepository.findJalousie())
            Constant.EntityMetadata.Rolstor -> Option.fromNullable(entityMetadataRepository.findRolstor())
            else -> Option.empty()
        }
    }

}
