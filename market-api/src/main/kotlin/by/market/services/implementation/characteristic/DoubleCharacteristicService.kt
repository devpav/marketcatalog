package by.market.services.implementation.characteristic

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.repository.characteristic.list.DoubleListCharacteristicRepository
import by.market.services.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class DoubleCharacteristicService(repository: DoubleListCharacteristicRepository)
    : BaseCharacteristicService<DoubleCharacteristic, DoubleListCharacteristicRepository>(repository)
