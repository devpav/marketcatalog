package by.market.resources.system.implementation.characteristic.list

import by.market.domain.characteristics.list.StringListCharacteristic
import by.market.resources.system.implementation.characteristic.BaseCharacteristicResource
import by.market.resources.system.implementation.characteristic.BaseListCharacteristicResource
import by.market.services.implementation.characteristic.list.StringListCharacteristicService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/string-characteristic")
class StringListCharacteristicResource(service: StringListCharacteristicService)
    : BaseListCharacteristicResource<StringListCharacteristicService, StringListCharacteristic>(service)
