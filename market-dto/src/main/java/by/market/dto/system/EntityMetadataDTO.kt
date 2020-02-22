package by.market.mapper.dto.system

import by.market.dto.system.ContainerMetadataDTO
import by.market.mapper.dto.BaseEntityDTO

class EntityMetadataDTO : BaseEntityDTO() {
    var tableName: String? = null

    var description: String? = null

    var containerDTO: ContainerMetadataDTO? = null
}
