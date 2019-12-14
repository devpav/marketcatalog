package by.market.parser.mapper

import by.market.domain.product.ProductCornice

class ProductCorniceMapper : BaseParserMapper<ProductCornice>() {
    override fun makeEmptyProduct(): ProductCornice = ProductCornice()

    override fun insertOrUpdateInDatabase(product: ProductCornice) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
