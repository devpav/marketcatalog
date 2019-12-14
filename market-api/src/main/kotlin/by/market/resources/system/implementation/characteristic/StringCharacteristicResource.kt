package by.market.resources.system.implementation.characteristic

import by.market.domain.characteristics.list.StringListCharacteristic
import by.market.resources.system.implementation.BaseCharacteristicResource
import by.market.services.implementation.characteristic.StringCharacteristicService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/string-characteristic")
class StringCharacteristicResource(service: StringCharacteristicService)
    : BaseCharacteristicResource<StringCharacteristicService, StringListCharacteristic>(service)
