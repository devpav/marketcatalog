package by.market.facade.system

import by.market.domain.system.EntityMetadata
import by.market.facade.AbstractFacade
import by.market.mapper.domain_dto_mapper.system.EntityMetadataMapper
import by.market.mapper.dto.system.EntityMetadataFrontEnd
import by.market.services.system.EntityMetadataService
import org.springframework.stereotype.Component

@Component
class EntityMetadataFacade(
        private val entityMetadataService: EntityMetadataService,
        private val entityMetadataMapper: EntityMetadataMapper
) : AbstractFacade<EntityMetadataFrontEnd, EntityMetadata>(entityMetadataService, entityMetadataMapper)
