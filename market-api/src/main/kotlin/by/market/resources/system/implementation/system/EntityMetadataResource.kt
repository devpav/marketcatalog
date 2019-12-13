package by.market.resources.system.implementation.system

import by.market.domain.system.EntityMetadata
import by.market.resources.system.implementation.BaseMutableResource
import by.market.services.system.EntityMetadataService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/entity-metadata")
class EntityMetadataResource(service: EntityMetadataService)
    : BaseMutableResource<EntityMetadataService, EntityMetadata>(service) {

    @GetMapping
    override fun findAll(): ResponseEntity<MutableList<EntityMetadata>> {
        return super.findAll()
    }
    
}
