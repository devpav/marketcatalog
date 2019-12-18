package by.market.domain.characteristics.single

import by.market.domain.characteristics.AbstractSingleCharacteristic
import javax.persistence.Entity
import javax.persistence.Table

@Table()
@Entity(name = "tbx_ch_double_characteristic")
class DoubleCharacteristic : AbstractSingleCharacteristic<Double>()
