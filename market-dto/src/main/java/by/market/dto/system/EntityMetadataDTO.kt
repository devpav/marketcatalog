package by.market.dto.system

import by.market.dto.BaseEntityDTO

class EntityMetadataDTO : BaseEntityDTO() {

    var tableName: String? = null

    var description: String? = null

    var container: ContainerMetadataDTO? = null

}
