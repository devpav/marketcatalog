package by.market.dto.characteristics

import by.market.dto.system.EntityMetadataDTO
import by.market.mapper.dto.BaseEntityDTO

abstract class AbstractCharacteristicDTO<T> : BaseEntityDTO() {

    var value: T? = null

    var productCharacteristicDTO: ProductCharacteristicDTO? = null

    var entityMetadata: EntityMetadataDTO? = null

}
