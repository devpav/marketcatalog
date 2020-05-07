package by.market.dto.characteristics

import by.market.dto.BaseEntityDTO
import java.util.*

open class AbstractCharacteristicDTO<T> : BaseEntityDTO() {

    var value: T? = null

    var characteristic: UUID? = null

    var product: UUID? = null

}
