package by.market.services.implementation.characteristic

import by.market.domain.characteristics.StringCharacteristic
import by.market.repository.characteristic.StringCharacteristicRepository
import by.market.services.implementation.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class StringCharacteristicService(repository: StringCharacteristicRepository)
    : BaseCharacteristicService<StringCharacteristic, StringCharacteristicRepository>(repository)
