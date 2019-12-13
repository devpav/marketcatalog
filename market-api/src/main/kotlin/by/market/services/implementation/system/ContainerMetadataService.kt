package by.market.services.implementation.system

import by.market.domain.system.ContainerMetadata
import by.market.repository.system.ContainerMetadataRepository
import by.market.services.implementation.BaseService
import org.springframework.stereotype.Service

@Service
class ContainerMetadataService(repository: ContainerMetadataRepository)
    : BaseService<ContainerMetadata, ContainerMetadataRepository>(repository)
