package by.market.dto.characteristics

import by.market.core.DataType
import java.util.*

data class UniversalCharacteristicDTO(val id: UUID, val title: String, val dataType: DataType, val values: Set<String>) {
}
