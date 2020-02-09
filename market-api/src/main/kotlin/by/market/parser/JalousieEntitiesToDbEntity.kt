package by.market.parser

import by.market.domain.product.ProductJalousie
import by.market.parser.mapper.ProductJalousieMapper
import enums.AsforosProductContext
import org.springframework.stereotype.Component

@Component
class JalousieEntitiesToDbEntity(mapper: ProductJalousieMapper)
    : AsforosEntitiesToDbEntity<ProductJalousie>(AsforosProductContext.Jalosie,
        mapper) {
}
