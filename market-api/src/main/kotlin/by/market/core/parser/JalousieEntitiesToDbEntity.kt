package by.market.core.parser

import by.market.core.parser.mapper.ProductJalousieMapper
import by.market.domain.product.ProductJalousie
import enums.AsforosProductContext
import org.springframework.stereotype.Component

@Component
class JalousieEntitiesToDbEntity(mapper: ProductJalousieMapper)
    : AsforosEntitiesToDbEntity<ProductJalousie>(AsforosProductContext.Jalosie,
        mapper) {
}
