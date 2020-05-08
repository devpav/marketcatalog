package by.market.domain.characteristics.single

import by.market.domain.characteristics.AbstractCharacteristic
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "TBX_CH_STRING_CHARACTERISTIC")
class StringCharacteristic : AbstractCharacteristic<String>()
