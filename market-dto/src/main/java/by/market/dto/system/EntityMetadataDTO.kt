package by.market.dto.system

import by.market.mapper.dto.BaseEntityDTO

class EntityMetadataDTO : BaseEntityDTO() {

    var tableName: String? = null

    var description: String? = null

    var containerDTO: ContainerMetadataDTO? = null

}
