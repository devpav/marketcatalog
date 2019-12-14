package by.market.parser.mapper

import by.market.domain.product.ProductCurtain
import by.market.repository.product.ProductCurtainRepository

class ProductCurtainMapper(rep: ProductCurtainRepository) : BaseParserMapper<ProductCurtain>(rep) {
    override fun getDatabaseProductOrMakeEmptyProduct(title: String): ProductCurtain = TODO("not implemented")
}
