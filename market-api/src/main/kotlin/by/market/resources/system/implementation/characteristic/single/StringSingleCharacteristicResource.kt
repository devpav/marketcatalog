package by.market.resources.system.implementation.characteristic.single

import by.market.domain.characteristics.single.StringCharacteristic
import by.market.resources.system.implementation.characteristic.BaseCharacteristicResource
import by.market.resources.system.implementation.characteristic.BaseSingleCharacteristicResource
import by.market.services.implementation.characteristic.single.StringSingleCharacteristicService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/string-characteristic")
class StringSingleCharacteristicResource(service: StringSingleCharacteristicService)
    : BaseSingleCharacteristicResource<StringSingleCharacteristicService, StringCharacteristic>(service)
