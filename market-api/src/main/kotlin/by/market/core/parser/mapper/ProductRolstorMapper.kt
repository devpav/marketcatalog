package by.market.core.parser.mapper

import by.market.domain.product.ProductRolstor
import by.market.repository.product.ProductRolstorRepository
import org.springframework.stereotype.Component

@Component
class ProductRolstorMapper(rep: ProductRolstorRepository) : BaseParserMapper<ProductRolstor>(rep) {
    override fun getEntity() = ProductRolstor()
}
