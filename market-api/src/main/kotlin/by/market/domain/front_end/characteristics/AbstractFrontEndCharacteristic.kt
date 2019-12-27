package by.market.domain.front_end.characteristics

import by.market.domain.front_end.BaseFrontEndEntity
import by.market.domain.front_end.system.EntityMetadataFrontEnd

abstract class AbstractFrontEndCharacteristic<T> : BaseFrontEndEntity() {

    var value: T? = null

    var productCharacteristic: ProductFrontEndCharacteristic? = null

    var entityMetadata: EntityMetadataFrontEnd? = null
}
