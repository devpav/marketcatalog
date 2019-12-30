package by.market.parser.mapper

import by.market.domain.product.ProductCornice
import by.market.repository.product.ProductCorniceRepository
import org.springframework.stereotype.Component

@Component("productCorniceAsforMapper")
open class ProductCorniceMapper(rep: ProductCorniceRepository) : BaseParserMapper<ProductCornice>(rep) {

    override fun getEntity() = ProductCornice()

}
