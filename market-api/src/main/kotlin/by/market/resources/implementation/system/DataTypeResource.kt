package by.market.resources.implementation.system

import by.market.core.facade.system.DataTypeFacade
import by.market.mapper.dto.system.DataTypeFrontEnd
import by.market.resources.BaseMutableResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/data-type")
class DataTypeResource(facade: DataTypeFacade): BaseMutableResource<DataTypeFrontEnd, DataTypeFacade>(facade)
