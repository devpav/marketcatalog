package by.market.services.implementation.characteristic

import by.market.domain.characteristics.list.StringListCharacteristic
import by.market.repository.characteristic.list.StringListCharacteristicRepository
import by.market.services.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class StringCharacteristicService(repository: StringListCharacteristicRepository)
    : BaseCharacteristicService<StringListCharacteristic, StringListCharacteristicRepository>(repository)
