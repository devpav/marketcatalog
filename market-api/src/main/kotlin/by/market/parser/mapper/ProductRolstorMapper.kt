package by.market.parser.mapper

import by.market.domain.product.ProductJalosie
import by.market.domain.product.ProductRolstor
import by.market.repository.product.ProductJalosieRepository
import by.market.repository.product.ProductRolstorRepository
import org.springframework.stereotype.Component

@Component
open class ProductRolstorMapper(rep: ProductRolstorRepository) : BaseParserMapper<ProductRolstor>(rep) {
    override fun getEntity() = ProductRolstor()
}
