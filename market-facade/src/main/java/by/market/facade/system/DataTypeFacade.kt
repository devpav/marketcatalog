package by.market.core.facade.system

import by.market.core.facade.BaseSystemFacade
import by.market.domain.system.DataType
import by.market.dto.system.DataTypeDTO
import by.market.dto.system.DataTypeService
import by.market.mapper.domain_dto_mapper.system.DataTypeMapper
import org.springframework.stereotype.Component

@Component
class DataTypeFacade(
        dataTypeService: DataTypeService,
        dataTypeMapper: DataTypeMapper
): BaseSystemFacade<DataTypeDTO, DataType, DataTypeService>(dataTypeService, dataTypeMapper)
