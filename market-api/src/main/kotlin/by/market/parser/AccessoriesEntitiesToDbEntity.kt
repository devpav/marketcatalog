package by.market.parser

import by.market.domain.product.ProductAccessory
import by.market.parser.mapper.ProductAccessoryMapper
import by.market.repository.product.ProductAccessoryRepository
import enums.AsforosProductContext
import org.springframework.stereotype.Component
import parser.AsforosProductParser

@Component
class AccessoriesEntitiesToDbEntity(rep: ProductAccessoryRepository)
    : AsforosEntitiesToDbEntity<ProductAccessory>(AsforosProductParser(),
        AsforosProductContext.Accessories,
        ProductAccessoryMapper(rep)) {
}
