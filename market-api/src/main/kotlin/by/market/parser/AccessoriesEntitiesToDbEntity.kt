package by.market.parser

import by.market.domain.product.ProductAccessory
import by.market.parser.mapper.ProductAccessoryMapper
import enums.AsforosProductContext
import org.springframework.stereotype.Component

@Component
class AccessoriesEntitiesToDbEntity(mapper: ProductAccessoryMapper)
    : AsforosEntitiesToDbEntity<ProductAccessory>(AsforosProductContext.Accessories,
        mapper) {
}
