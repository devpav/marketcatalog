package by.market.services.system

import by.market.domain.system.ContainerMetadata
import by.market.repository.system.ContainerMetadataRepository
import by.market.services.BaseService
import org.springframework.stereotype.Service

@Service
class ContainerMetadataService(repository: ContainerMetadataRepository)
    : BaseService<ContainerMetadata, ContainerMetadataRepository>(repository)
