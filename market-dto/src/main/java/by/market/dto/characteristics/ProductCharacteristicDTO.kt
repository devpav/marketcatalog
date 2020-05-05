package by.market.dto.characteristics

import by.market.dto.system.DataTypeDTO
import by.market.mapper.dto.BaseEntityDTO

class ProductCharacteristicDTO : BaseEntityDTO() {

    var title: String? = null

    var dataType: DataTypeDTO? = null

}
