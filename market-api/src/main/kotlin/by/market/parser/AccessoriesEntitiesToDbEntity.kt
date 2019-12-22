package by.market.parser

import by.market.domain.product.ProductAccessory
import by.market.parser.mapper.ProductAccessoryMapper
import enums.AsforosProductContext
import org.springframework.stereotype.Component
import parser.AsforosProductParser

@Component
class AccessoriesEntitiesToDbEntity(mapper: ProductAccessoryMapper)
    : AsforosEntitiesToDbEntity<ProductAccessory>(AsforosProductParser(),
        AsforosProductContext.Accessories,
        mapper) {
}
