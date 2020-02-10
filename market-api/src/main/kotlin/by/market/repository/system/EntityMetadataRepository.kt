package by.market.repository.system

import by.market.core.Constant
import by.market.domain.system.EntityMetadata
import by.market.repository.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface EntityMetadataRepository : BaseRepository<EntityMetadata> {

    fun findByTableName(tableName: String): EntityMetadata

    fun findAccessory(): EntityMetadata = findByTableName(Constant.EntityMetadata.Accessory)

    fun findCornice(): EntityMetadata = findByTableName(Constant.EntityMetadata.Cornice)

    fun findJalousie(): EntityMetadata = findByTableName(Constant.EntityMetadata.Jalousie)

    fun findRolstor(): EntityMetadata = findByTableName(Constant.EntityMetadata.Rolstor)
}
