package by.market.core.facade.system

import by.market.core.facade.BaseSystemFacade
import by.market.domain.system.ContainerMetadata
import by.market.dto.system.ContainerMetadataDTO
import by.market.dto.system.ContainerMetadataService
import by.market.mapper.domain_dto_mapper.system.ContainerMetadataMapper
import org.springframework.stereotype.Component

@Component
class ContainerMetadataFacade(
        containerMetadataService: ContainerMetadataService,
        containerMetadataMapper: ContainerMetadataMapper
): BaseSystemFacade<ContainerMetadataDTO, ContainerMetadata, ContainerMetadataService>(containerMetadataService, containerMetadataMapper)
