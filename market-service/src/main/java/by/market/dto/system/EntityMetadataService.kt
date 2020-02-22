package by.market.dto.system

import by.market.domain.system.EntityMetadata
import by.market.repository.system.EntityMetadataRepository
import org.springframework.stereotype.Service

@Service
class EntityMetadataService(repository: EntityMetadataRepository)
    : BaseSystemCharacteristicService<EntityMetadata, EntityMetadataRepository>(repository)
