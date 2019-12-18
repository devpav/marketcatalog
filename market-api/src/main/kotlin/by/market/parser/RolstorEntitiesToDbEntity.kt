package by.market.parser

import by.market.domain.product.ProductRolstor
import by.market.parser.mapper.ProductRolstorMapper
import by.market.repository.product.ProductRolstorRepository
import enums.AsforosProductContext
import org.springframework.stereotype.Component
import parser.AsforosProductParser

@Component
class RolstorEntitiesToDbEntity(rep: ProductRolstorRepository)
    : AsforosEntitiesToDbEntity<ProductRolstor>(AsforosProductParser(),
        AsforosProductContext.Rolstor,
        ProductRolstorMapper(rep)) {
}
