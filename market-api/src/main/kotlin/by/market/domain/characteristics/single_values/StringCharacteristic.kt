package by.market.domain.characteristics.single_values

import by.market.domain.characteristics.AbstractCharacteristic
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbx_ch_string_characteristic")
class StringCharacteristic : AbstractCharacteristic<String>()
