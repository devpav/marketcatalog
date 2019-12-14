package by.market.resources.system.implementation.characteristic

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.resources.system.implementation.BaseCharacteristicResource
import by.market.services.implementation.characteristic.list.DoubleListCharacteristicService
import by.market.services.implementation.characteristic.single.DoubleSingleCharacteristicService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/double-characteristic")
class DoubleCharacteristicResource(service: DoubleSingleCharacteristicService)
    : BaseCharacteristicResource<DoubleSingleCharacteristicService, DoubleCharacteristic>(service)
