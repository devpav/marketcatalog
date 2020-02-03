package by.market.mapper.dto.characteristics

import by.market.core.DataType
import java.util.*

data class UniversalCharacteristicFrontEnd(val id: UUID, val title: String, val dataType: DataType, val values: Set<String>) {
}
