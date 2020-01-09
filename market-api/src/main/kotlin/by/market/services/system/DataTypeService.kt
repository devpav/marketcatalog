package by.market.services.system

import by.market.domain.system.DataType
import by.market.repository.system.DataTypeRepository
import org.springframework.stereotype.Service

@Service
class DataTypeService(repository: DataTypeRepository)
    : BaseSystemCharacteristicService<DataType, DataTypeRepository>(repository)
