package by.market.parser.mapper

import by.market.domain.product.ProductBlind
import by.market.repository.product.ProductBlindRepository
import org.springframework.stereotype.Component

@Component
open class ProductBlindMapper(rep: ProductBlindRepository) : BaseParserMapper<ProductBlind>(rep) {

    override fun getEntity() = ProductBlind()

}
