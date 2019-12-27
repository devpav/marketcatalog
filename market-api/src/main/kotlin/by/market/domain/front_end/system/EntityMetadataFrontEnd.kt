package by.market.domain.front_end.system

import by.market.domain.front_end.BaseFrontEndEntity

class EntityMetadataFrontEnd : BaseFrontEndEntity() {
    var tableName: String? = null

    var description: String? = null

    var container: ContainerFrontEndMetadata? = null
}
