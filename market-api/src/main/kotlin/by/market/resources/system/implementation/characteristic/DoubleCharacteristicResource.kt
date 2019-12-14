package by.market.resources.system.implementation.characteristic

import by.market.domain.characteristics.single_values.DoubleCharacteristic
import by.market.resources.system.implementation.BaseCharacteristicResource
import by.market.services.implementation.characteristic.DoubleCharacteristicService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/double-characteristic")
class DoubleCharacteristicResource(service: DoubleCharacteristicService)
    : BaseCharacteristicResource<DoubleCharacteristicService, DoubleCharacteristic>(service)
