package by.market.mapper.dto.characteristics

import by.market.domain.system.DataType
import by.market.mapper.dto.BaseFrontEndEntity

class ProductFrontEndCharacteristic : BaseFrontEndEntity() {

    var title: String? = null

    var dataType: DataType? = null
}
