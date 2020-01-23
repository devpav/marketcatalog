package by.market.mapper.dto.characteristics

import by.market.core.DataType
import by.market.mapper.dto.BaseFrontEndEntity

data class UniversalCharacteristicFrontEnd(val title: String, val dataType: DataType, val values: List<String>)
    : BaseFrontEndEntity() {
}
