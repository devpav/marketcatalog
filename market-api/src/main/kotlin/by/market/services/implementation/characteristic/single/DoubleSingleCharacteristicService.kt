package by.market.services.implementation.characteristic.single

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.repository.characteristic.list.DoubleListCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.services.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class DoubleSingleCharacteristicService(repository: DoubleSingleCharacteristicRepository)
    : BaseCharacteristicService<DoubleCharacteristic, DoubleSingleCharacteristicRepository>(repository)
