package by.market.domain.characteristics.list

import by.market.domain.characteristics.AbstractListCharacteristic
import javax.persistence.Entity
import javax.persistence.Table

@Table()
@Entity(name = "tbx_ch_double_list_characteristic")
class DoubleListCharacteristic : AbstractListCharacteristic<Double>()
