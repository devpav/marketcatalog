package by.market.services.impl

import by.market.domain.BaseEntity
import by.market.domain.system.ContainerMetadata
import by.market.domain.system.DataType
import by.market.domain.system.EntityMetadata
import by.market.repository.BaseRepository
import by.market.repository.system.ContainerMetadataRepository
import by.market.repository.system.DataTypeRepository
import by.market.repository.system.EntityMetadataRepository
import by.market.services.ISystemService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

open class BaseSystemCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : ISystemService<TEntity>, BaseService<TEntity, TRepository>(rep)



@Service
class ContainerMetadataService(repository: ContainerMetadataRepository)
    : BaseSystemCharacteristicService<ContainerMetadata, ContainerMetadataRepository>(repository)


@Service
class DataTypeService(repository: DataTypeRepository)
    : BaseSystemCharacteristicService<DataType, DataTypeRepository>(repository)

@Service
open class EntityMetadataService(repository: EntityMetadataRepository, private val containerMetadataService: ContainerMetadataService)
    : BaseSystemCharacteristicService<EntityMetadata, EntityMetadataRepository>(repository) {

    fun findByTableName(tableName: String): EntityMetadata? {
        return rep.findByTableName(tableName)
    }

    @Transactional
    override fun save(entity: EntityMetadata): EntityMetadata {
        var containerMetadata = entity.container

        if (containerMetadata != null) {
            containerMetadata = if (containerMetadata.id == null) null else
                containerMetadataService.getReference(containerMetadata.id!!)
        }

        entity.container = containerMetadata

        return super.save(entity)
    }

}

