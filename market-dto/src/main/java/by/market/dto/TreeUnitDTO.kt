package by.market.dto

import java.util.*

class TreeUnitDTO {

    var id: UUID? = null
    var value: String? = null
    var description: String? = null
    var subunits: List<TreeUnitDTO> = mutableListOf()

}