package by.market.dto.characteristics

import by.market.domain.system.DataType
import by.market.mapper.dto.BaseEntityDTO

class ProductCharacteristicDTO : BaseEntityDTO() {

    var title: String? = null

    var dataType: DataType? = null
}
