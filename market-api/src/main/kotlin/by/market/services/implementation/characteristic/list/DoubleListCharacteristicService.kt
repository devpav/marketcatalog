package by.market.services.implementation.characteristic.list

import by.market.domain.characteristics.list.DoubleListCharacteristic
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.repository.characteristic.list.DoubleListCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.services.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class DoubleListCharacteristicService(repository: DoubleListCharacteristicRepository)
    : BaseCharacteristicService<DoubleListCharacteristic, DoubleListCharacteristicRepository>(repository)
