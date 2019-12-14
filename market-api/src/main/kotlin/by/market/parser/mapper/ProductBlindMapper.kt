package by.market.parser.mapper

import by.market.domain.product.ProductBlind
import by.market.repository.product.ProductBlindRepository

class ProductBlindMapper(rep: ProductBlindRepository) : BaseParserMapper<ProductBlind>(rep) {
    override fun getDatabaseProductOrMakeEmptyProduct(title: String): ProductBlind = TODO()
}
