package by.market.resources.system.implementation.characteristic.list

import by.market.domain.characteristics.list.DoubleListCharacteristic
import by.market.resources.system.implementation.characteristic.BaseCharacteristicResource
import by.market.resources.system.implementation.characteristic.BaseListCharacteristicResource
import by.market.services.implementation.characteristic.list.DoubleListCharacteristicService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/double-characteristic")
class DoubleListCharacteristicResource(service: DoubleListCharacteristicService)
    : BaseListCharacteristicResource<DoubleListCharacteristicService, DoubleListCharacteristic>(service)
