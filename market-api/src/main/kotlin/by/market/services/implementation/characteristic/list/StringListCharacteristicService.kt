package by.market.services.implementation.characteristic.list

import by.market.domain.characteristics.list.StringListCharacteristic
import by.market.repository.characteristic.list.StringListCharacteristicRepository
import by.market.services.implementation.characteristic.BaseCharacteristicService
import by.market.services.implementation.characteristic.BaseListCharacteristicService
import org.springframework.stereotype.Service

@Service
class StringListCharacteristicService(repository: StringListCharacteristicRepository)
    : BaseListCharacteristicService<StringListCharacteristic, StringListCharacteristicRepository>(repository)