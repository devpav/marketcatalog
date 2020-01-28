package by.market.repository.product.Jinq

import by.market.domain.product.ProductCornice
import by.market.repository.BaseJinqRepositoryImpl
import org.springframework.stereotype.Repository

@Repository
class JinqProductCorniceRepository : BaseJinqRepositoryImpl<ProductCornice>() {
    override fun entityType(): Class<ProductCornice> = ProductCornice::class.java
}
