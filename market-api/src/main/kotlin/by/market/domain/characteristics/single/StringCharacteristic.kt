package by.market.domain.characteristics.single

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.characteristics.AbstractSingleCharacteristic
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbx_ch_string_characteristic")
class StringCharacteristic : AbstractSingleCharacteristic<String>()
