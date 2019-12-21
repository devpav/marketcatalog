package by.market.repository.characteristic.single

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.repository.characteristic.AbstractSingleCharacteristicRepository
import org.springframework.stereotype.Repository

@Repository
interface DoubleSingleCharacteristicRepository
    : AbstractSingleCharacteristicRepository<DoubleCharacteristic, Double> {


}
