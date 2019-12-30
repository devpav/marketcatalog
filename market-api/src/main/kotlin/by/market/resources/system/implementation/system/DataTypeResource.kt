package by.market.resources.system.implementation.system

import by.market.facade.system.DataTypeFacade
import by.market.mapper.dto.system.DataTypeFrontEnd
import by.market.resources.system.implementation.BaseMutableResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/data-type")
class DataTypeResource(facade: DataTypeFacade): BaseMutableResource<DataTypeFrontEnd, DataTypeFacade>(facade)
