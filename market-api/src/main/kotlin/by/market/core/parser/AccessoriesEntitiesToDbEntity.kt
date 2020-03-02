package by.market.core.parser

import by.market.core.parser.mapper.ProductAccessoryMapper
import by.market.domain.product.ProductAccessory
import enums.AsforosProductContext
import org.springframework.stereotype.Component

@Component
class AccessoriesEntitiesToDbEntity(mapper: ProductAccessoryMapper)
    : AsforosEntitiesToDbEntity<ProductAccessory>(AsforosProductContext.Accessories,
        mapper) {
}
