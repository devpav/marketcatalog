package by.market.resources.system

import by.market.core.facade.system.DataTypeFacade
import by.market.dto.system.DataTypeDTO
import by.market.resources.AbstractResource
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/data-type")
class DataTypeResource(facade: DataTypeFacade): AbstractResource<DataTypeDTO>(facade)
