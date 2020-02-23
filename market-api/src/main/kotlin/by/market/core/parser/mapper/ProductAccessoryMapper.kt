package by.market.core.parser.mapper

import by.market.domain.product.ProductAccessory
import by.market.repository.product.ProductAccessoryRepository
import org.springframework.stereotype.Component

@Component
class ProductAccessoryMapper(rep: ProductAccessoryRepository) : BaseParserMapper<ProductAccessory>(rep) {

    override fun getEntity() = ProductAccessory()

}
