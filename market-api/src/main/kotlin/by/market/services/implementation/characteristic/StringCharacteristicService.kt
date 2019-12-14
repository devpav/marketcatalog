package by.market.services.implementation.characteristic

import by.market.domain.characteristics.list_values.StringListCharacteristic
import by.market.repository.characteristic.StringCharacteristicRepository
import by.market.services.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class StringCharacteristicService(repository: StringCharacteristicRepository)
    : BaseCharacteristicService<StringListCharacteristic, StringCharacteristicRepository>(repository)
