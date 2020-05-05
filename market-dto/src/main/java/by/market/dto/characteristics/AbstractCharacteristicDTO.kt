package by.market.dto.characteristics

import by.market.dto.BaseEntityDTO
import by.market.dto.product.ProductDTO
import by.market.dto.system.EntityMetadataDTO

open class AbstractCharacteristicDTO<T> : BaseEntityDTO() {

    var value: T? = null

    var characteristic: ProductCharacteristicDTO? = null

    var entityMetadata: EntityMetadataDTO? = null

    var product: ProductDTO? = null

}
