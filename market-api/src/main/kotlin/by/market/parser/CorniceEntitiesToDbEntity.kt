package by.market.parser

import by.market.domain.product.ProductCornice
import by.market.parser.mapper.ProductCorniceMapper
import by.market.repository.product.ProductCorniceRepository
import enums.AsforosProductContext
import org.springframework.stereotype.Component
import parser.AsforosProductParser

@Component
class CorniceEntitiesToDbEntity(mapper: ProductCorniceMapper)
    : AsforosEntitiesToDbEntity<ProductCornice>(AsforosProductParser(),
        AsforosProductContext.Cornice,
        mapper) {
}
