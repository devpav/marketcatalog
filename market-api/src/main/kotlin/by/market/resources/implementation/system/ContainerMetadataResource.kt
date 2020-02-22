package by.market.resources.implementation.system

import by.market.core.facade.system.ContainerMetadataFacade
import by.market.mapper.dto.system.ContainerMetadataFrontEnd
import by.market.resources.BaseMutableResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/container-metadata")
class ContainerMetadataResource(facade: ContainerMetadataFacade)
    : BaseMutableResource<ContainerMetadataFrontEnd, ContainerMetadataFacade>(facade)
