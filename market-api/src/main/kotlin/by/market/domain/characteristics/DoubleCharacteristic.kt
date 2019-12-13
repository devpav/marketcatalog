package by.market.domain.characteristics

import javax.persistence.Entity
import javax.persistence.Table

@Table()
@Entity(name = "tbx_ch_double_characteristic")
class DoubleCharacteristic : AbstractCharacteristic<Double>()
