package by.market.core.facade.system

import by.market.core.facade.BaseSystemFacade
import by.market.domain.system.EntityMetadata
import by.market.dto.system.EntityMetadataService
import by.market.mapper.domain_dto_mapper.system.EntityMetadataMapper
import by.market.mapper.dto.system.EntityMetadataDTO
import org.springframework.stereotype.Component

@Component
class EntityMetadataFacade(
        entityMetadataService: EntityMetadataService,
        entityMetadataMapper: EntityMetadataMapper
) : BaseSystemFacade<EntityMetadataDTO, EntityMetadata, EntityMetadataService>(entityMetadataService, entityMetadataMapper)
