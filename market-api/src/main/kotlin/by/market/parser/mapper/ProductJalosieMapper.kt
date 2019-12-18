package by.market.parser.mapper

import by.market.domain.product.ProductJalosie
import by.market.repository.product.ProductJalosieRepository
import org.springframework.stereotype.Component

@Component
open class ProductJalosieMapper(rep: ProductJalosieRepository) : BaseParserMapper<ProductJalosie>(rep) {
    override fun getEntity() = ProductJalosie()
}
