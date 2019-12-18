package by.market.parser.mapper

import by.market.domain.product.ProductCurtain
import by.market.repository.product.ProductCurtainRepository
import org.springframework.stereotype.Component

@Component
open class ProductCurtainMapper(rep: ProductCurtainRepository) : BaseParserMapper<ProductCurtain>(rep) {

    override fun getEntity() = ProductCurtain()

}
