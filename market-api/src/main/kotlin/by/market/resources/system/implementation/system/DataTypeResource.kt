package by.market.resources.system.implementation.system

import by.market.domain.system.DataType
import by.market.resources.system.implementation.BaseMutableResource
import by.market.services.implementation.system.DataTypeService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/data-type")
class DataTypeResource(service: DataTypeService): BaseMutableResource<DataTypeService, DataType>(service)
