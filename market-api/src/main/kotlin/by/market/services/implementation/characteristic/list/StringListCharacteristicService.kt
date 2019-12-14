package by.market.services.implementation.characteristic.list

import by.market.domain.characteristics.list.StringListCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.repository.characteristic.list.StringListCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.services.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class StringListCharacteristicService(repository: StringListCharacteristicRepository)
    : BaseCharacteristicService<StringListCharacteristic, StringListCharacteristicRepository>(repository)
