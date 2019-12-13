package by.market.services.implementation.system

import by.market.domain.system.EntityMetadata
import by.market.repository.system.EntityMetadataRepository
import by.market.services.implementation.BaseService
import org.springframework.stereotype.Service

@Service
class EntityMetadataService(repository: EntityMetadataRepository)
    : BaseService<EntityMetadata, EntityMetadataRepository>(repository)
