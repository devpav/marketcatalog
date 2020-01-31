package by.market.facade.system

import by.market.domain.system.ContainerMetadata
import by.market.facade.BaseSystemFacade
import by.market.mapper.domain_dto_mapper.system.ContainerMetadataMapper
import by.market.mapper.dto.system.ContainerMetadataFrontEnd
import by.market.services.system.ContainerMetadataService
import org.springframework.stereotype.Component

@Component
class ContainerMetadataFacade(
        containerMetadataService: ContainerMetadataService,
        containerMetadataMapper: ContainerMetadataMapper
): BaseSystemFacade<ContainerMetadataFrontEnd, ContainerMetadata, ContainerMetadataService>(containerMetadataService, containerMetadataMapper)
