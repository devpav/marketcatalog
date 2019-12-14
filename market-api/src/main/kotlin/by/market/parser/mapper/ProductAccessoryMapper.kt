package by.market.parser.mapper

import by.market.domain.product.ProductAccessory

class ProductAccessoryMapper : BaseParserMapper<ProductAccessory>() {
    override fun makeEmptyProduct(): ProductAccessory = ProductAccessory()

    override fun insertOrUpdateInDatabase(product: ProductAccessory) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
