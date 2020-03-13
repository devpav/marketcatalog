package by.market.dto.characteristics

import by.market.dto.system.DataTypeDTO
import java.util.*

data class UniversalCharacteristicDTO(val id: UUID, val title: String, val dataType: DataTypeDTO, val values: Set<String>) {
}
