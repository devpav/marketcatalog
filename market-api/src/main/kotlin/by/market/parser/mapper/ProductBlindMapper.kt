package by.market.parser.mapper

import by.market.domain.product.ProductBlind

class ProductBlindMapper : BaseParserMapper<ProductBlind>() {
    override fun makeEmptyProduct(): ProductBlind = ProductBlind()

    override fun insertOrUpdateInDatabase(product: ProductBlind) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
