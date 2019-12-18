package by.market.parser

import by.market.domain.product.ProductCornice
import by.market.parser.mapper.ProductCorniceMapper
import by.market.repository.product.ProductCorniceRepository
import enums.AsforosProductContext
import org.springframework.stereotype.Component
import parser.AsforosProductParser

@Component
class CorniceEntitiesToDbEntity(rep: ProductCorniceRepository)
    : AsforosEntitiesToDbEntity<ProductCornice>(AsforosProductParser(),
        AsforosProductContext.Cornice,
        ProductCorniceMapper(rep)) {
}
