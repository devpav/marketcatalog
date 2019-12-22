package by.market.parser

import by.market.domain.product.ProductRolstor
import by.market.parser.mapper.ProductRolstorMapper
import enums.AsforosProductContext
import org.springframework.stereotype.Component
import parser.AsforosProductParser

@Component
class RolstorEntitiesToDbEntity(mapper: ProductRolstorMapper)
    : AsforosEntitiesToDbEntity<ProductRolstor>(AsforosProductParser(),
        AsforosProductContext.Rolstor,
        mapper) {
}
