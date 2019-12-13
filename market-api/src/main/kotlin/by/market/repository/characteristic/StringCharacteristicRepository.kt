package by.market.repository.characteristic

import by.market.domain.characteristics.StringCharacteristic
import by.market.repository.AbstractCharacteristicRepository
import org.springframework.stereotype.Repository

@Repository
interface StringCharacteristicRepository : AbstractCharacteristicRepository<StringCharacteristic, String>
