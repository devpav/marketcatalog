package by.market.resources.system.implementation.characteristic.single

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.resources.system.implementation.characteristic.BaseCharacteristicResource
import by.market.resources.system.implementation.characteristic.BaseSingleCharacteristicResource
import by.market.services.implementation.characteristic.single.DoubleSingleCharacteristicService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/double-characteristic")
class DoubleSingleCharacteristicResource(service: DoubleSingleCharacteristicService)
    : BaseSingleCharacteristicResource<DoubleSingleCharacteristicService, DoubleCharacteristic>(service)
