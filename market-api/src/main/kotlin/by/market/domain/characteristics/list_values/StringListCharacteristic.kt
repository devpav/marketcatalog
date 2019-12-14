package by.market.domain.characteristics.list_values

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.characteristics.AbstractListCharacteristic
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbx_ch_string_list_characteristic")
class StringListCharacteristic : AbstractListCharacteristic<String>()
