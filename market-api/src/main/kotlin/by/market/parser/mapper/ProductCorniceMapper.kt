package by.market.parser.mapper

import by.market.domain.product.ProductCornice
import by.market.repository.product.ProductCorniceRepository

class ProductCorniceMapper(rep: ProductCorniceRepository) : BaseParserMapper<ProductCornice>(rep) {
    override fun getDatabaseProductOrMakeEmptyProduct(title: String): ProductCornice = TODO("not implemented")
}
