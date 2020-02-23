package by.market.core.parser

import by.market.core.parser.mapper.ProductCorniceMapper
import by.market.domain.product.ProductCornice
import enums.AsforosProductContext
import org.springframework.stereotype.Component

@Component
class CorniceEntitiesToDbEntity(mapper: ProductCorniceMapper) : AsforosEntitiesToDbEntity<ProductCornice>(AsforosProductContext.Cornice, mapper)
