package by.market.parser.mapper

import by.market.domain.product.ProductAccessory
import by.market.repository.product.ProductAccessoryRepository

class ProductAccessoryMapper(rep: ProductAccessoryRepository) : BaseParserMapper<ProductAccessory>(rep) {
    override fun getDatabaseProductOrMakeEmptyProduct(title: String): ProductAccessory = TODO()
}
