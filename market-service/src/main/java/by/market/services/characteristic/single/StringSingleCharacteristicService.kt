package by.market.services.characteristic.single

import by.market.domain.characteristics.single.StringCharacteristic
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.services.characteristic.BaseSingleCharacteristicService
import org.springframework.stereotype.Service

@Service
class StringSingleCharacteristicService(repository: StringSingleCharacteristicRepository)
    : BaseSingleCharacteristicService<StringCharacteristic, StringSingleCharacteristicRepository>(repository)
