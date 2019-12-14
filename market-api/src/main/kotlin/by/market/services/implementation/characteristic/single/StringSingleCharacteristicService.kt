package by.market.services.implementation.characteristic.single

import by.market.domain.characteristics.single.StringCharacteristic
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.services.BaseCharacteristicService
import org.springframework.stereotype.Service

@Service
class StringSingleCharacteristicService(repository: StringSingleCharacteristicRepository)
    : BaseCharacteristicService<StringCharacteristic, StringSingleCharacteristicRepository>(repository)
