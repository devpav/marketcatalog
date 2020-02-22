package by.market.dto.system

import by.market.domain.system.ContainerMetadata
import by.market.repository.system.ContainerMetadataRepository
import org.springframework.stereotype.Service

@Service
class ContainerMetadataService(repository: ContainerMetadataRepository)
    : BaseSystemCharacteristicService<ContainerMetadata, ContainerMetadataRepository>(repository)
