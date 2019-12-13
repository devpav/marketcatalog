package by.market.services.system.implementation.system

import by.market.domain.system.DataType
import by.market.repository.system.DataTypeRepository
import by.market.services.implementation.BaseService
import org.springframework.stereotype.Service

@Service
class DataTypeService(repository: DataTypeRepository)
    : BaseService<DataType, DataTypeRepository>(repository)
