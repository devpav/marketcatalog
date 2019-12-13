package by.market.resources.system.implementation.system

import by.market.domain.system.ContainerMetadata
import by.market.resources.system.implementation.BaseMutableResource
import by.market.services.system.ContainerMetadataService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/container-metadata")
class ContainerMetadataResource(service: ContainerMetadataService)
    : BaseMutableResource<ContainerMetadataService, ContainerMetadata>(service)
