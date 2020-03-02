package by.market.core.parser.mapper

import by.market.domain.product.ProductJalousie
import by.market.repository.product.ProductJalousieRepository
import org.springframework.stereotype.Component

@Component
class ProductJalousieMapper(rep: ProductJalousieRepository) : BaseParserMapper<ProductJalousie>(rep) {
    override fun getEntity() = ProductJalousie()
}
