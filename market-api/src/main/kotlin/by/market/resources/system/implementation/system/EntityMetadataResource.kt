package by.market.resources.system.implementation.system

import by.market.domain.system.EntityMetadata
import by.market.resources.system.implementation.BaseMutableResource
import by.market.services.system.implementation.system.EntityMetadataService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/entity-metadata")
class EntityMetadataResource(service: EntityMetadataService)
    : BaseMutableResource<EntityMetadataService, EntityMetadata>(service)
