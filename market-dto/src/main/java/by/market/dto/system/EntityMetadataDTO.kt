package by.market.dto.system

import by.market.dto.BaseEntityDTO
import java.util.*

class EntityMetadataDTO : BaseEntityDTO() {

    var tableName: String? = null

    var description: String? = null

    var container: UUID? = null

}
