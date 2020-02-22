package by.market.resources.system

import by.market.core.facade.system.EntityMetadataFacade
import by.market.mapper.dto.system.EntityMetadataFrontEnd
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/entity-metadata")
class EntityMetadataResource(service: EntityMetadataFacade)
    : BaseMutableResource<EntityMetadataFrontEnd, EntityMetadataFacade>(service)
