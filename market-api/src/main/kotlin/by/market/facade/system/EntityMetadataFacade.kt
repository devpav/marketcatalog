package by.market.facade.system

import by.market.domain.system.EntityMetadata
import by.market.facade.BaseSystemFacade
import by.market.mapper.domain_dto_mapper.system.EntityMetadataMapper
import by.market.mapper.dto.system.EntityMetadataFrontEnd
import by.market.services.system.EntityMetadataService
import org.springframework.stereotype.Component

@Component
class EntityMetadataFacade(
        entityMetadataService: EntityMetadataService,
        entityMetadataMapper: EntityMetadataMapper
) : BaseSystemFacade<EntityMetadataFrontEnd, EntityMetadata, EntityMetadataService>(entityMetadataService, entityMetadataMapper)
