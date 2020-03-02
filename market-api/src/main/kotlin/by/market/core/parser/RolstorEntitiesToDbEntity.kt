package by.market.core.parser

import by.market.core.parser.mapper.ProductRolstorMapper
import by.market.domain.product.ProductRolstor
import enums.AsforosProductContext
import org.springframework.stereotype.Component

@Component
class RolstorEntitiesToDbEntity(mapper: ProductRolstorMapper) : AsforosEntitiesToDbEntity<ProductRolstor>(AsforosProductContext.Rolstor, mapper)
