package by.market.dto.characteristics

import java.util.*

data class UniversalCharacteristicDTO(val id: UUID, val title: String, val dataType: String, val values: Set<String>) {
}
