package by.market.facade.system

import by.market.domain.system.DataType
import by.market.facade.BaseSystemFacade
import by.market.mapper.domain_dto_mapper.system.DataTypeMapper
import by.market.mapper.dto.system.DataTypeFrontEnd
import by.market.services.system.DataTypeService
import org.springframework.stereotype.Component

@Component
class DataTypeFacade(
        dataTypeService: DataTypeService,
        dataTypeMapper: DataTypeMapper
): BaseSystemFacade<DataTypeFrontEnd, DataType>(dataTypeService, dataTypeMapper)
