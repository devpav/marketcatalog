package by.market.repository.product.Jinq

import by.market.domain.product.ProductJalosie
import by.market.repository.BaseJinqRepositoryImpl
import org.springframework.stereotype.Repository

@Repository
class JinqProductJalosieRepository : BaseJinqRepositoryImpl<ProductJalosie>() {
    override fun entityType(): Class<ProductJalosie> = ProductJalosie::class.java
}
