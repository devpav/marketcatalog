package by.market.parser

import by.market.domain.product.ProductJalosie
import by.market.parser.mapper.ProductJalosieMapper
import enums.AsforosProductContext
import org.springframework.stereotype.Component
import parser.AsforosProductParser

@Component
class JalosieEntitiesToDbEntity(mapper: ProductJalosieMapper)
    : AsforosEntitiesToDbEntity<ProductJalosie>(AsforosProductParser(),
        AsforosProductContext.Jalosie,
        mapper) {
}
