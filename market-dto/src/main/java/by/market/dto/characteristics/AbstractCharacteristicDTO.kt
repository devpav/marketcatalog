package by.market.dto.characteristics

import by.market.mapper.dto.BaseEntityDTO
import by.market.mapper.dto.system.EntityMetadataDTO

abstract class AbstractCharacteristicDTO<T> : BaseEntityDTO() {

    var value: T? = null

    var productCharacteristicDTO: ProductCharacteristicDTO? = null

    var entityMetadata: EntityMetadataDTO? = null
}
