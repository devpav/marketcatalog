package by.market.parser.mapper

import by.market.domain.product.ProductCurtain

class ProductCurtainMapper : BaseParserMapper<ProductCurtain>() {
    override fun makeEmptyProduct(): ProductCurtain = ProductCurtain()

    override fun insertOrUpdateInDatabase(product: ProductCurtain) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
