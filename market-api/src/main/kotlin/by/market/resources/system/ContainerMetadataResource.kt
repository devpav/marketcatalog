package by.market.resources.system

import by.market.core.facade.system.ContainerMetadataFacade
import by.market.dto.system.ContainerMetadataDTO
import by.market.resources.AbstractResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/container-metadata")
class ContainerMetadataResource(facade: ContainerMetadataFacade) : AbstractResource<ContainerMetadataDTO>(facade)
