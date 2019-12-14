package by.market.services.implementation.characteristic

import by.market.domain.characteristics.single_values.DoubleCharacteristic
import by.market.repository.characteristic.DoubleCharacteristicRepository
import by.market.services.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class DoubleCharacteristicService(repository: DoubleCharacteristicRepository)
    : BaseCharacteristicService<DoubleCharacteristic, DoubleCharacteristicRepository>(repository)
