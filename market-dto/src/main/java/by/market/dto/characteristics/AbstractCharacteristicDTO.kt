package by.market.dto.characteristics

import by.market.dto.product.ProductDTO
import by.market.dto.system.EntityMetadataDTO
import by.market.mapper.dto.BaseEntityDTO

open class AbstractCharacteristicDTO<T> : BaseEntityDTO() {

    var value: T? = null

    var characteristic: ProductCharacteristicDTO? = null

    var entityMetadata: EntityMetadataDTO? = null

    var productDTO: ProductDTO? = null

}
