package by.market.parser

import by.market.domain.product.ProductCornice
import by.market.parser.mapper.ProductCorniceMapper
import enums.AsforosProductContext
import org.springframework.stereotype.Component

@Component
class CorniceEntitiesToDbEntity(mapper: ProductCorniceMapper)
    : AsforosEntitiesToDbEntity<ProductCornice>(AsforosProductContext.Cornice,
        mapper) {
}
