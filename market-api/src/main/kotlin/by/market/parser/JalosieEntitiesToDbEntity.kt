package by.market.parser

import by.market.domain.product.ProductJalosie
import by.market.parser.mapper.ProductJalosieMapper
import by.market.repository.product.ProductJalosieRepository
import enums.AsforosProductContext
import org.springframework.stereotype.Component
import parser.AsforosProductParser

@Component
class JalosieEntitiesToDbEntity(rep: ProductJalosieRepository)
    : AsforosEntitiesToDbEntity<ProductJalosie>(AsforosProductParser(),
        AsforosProductContext.Jalosie,
        ProductJalosieMapper(rep)) {
}
