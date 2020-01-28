package by.market.repository.product.Jinq

import by.market.domain.product.ProductRolstor
import by.market.repository.BaseJinqRepositoryImpl
import org.springframework.stereotype.Repository

@Repository
class JinqProductRolstorRepository : BaseJinqRepositoryImpl<ProductRolstor>() {
    override fun entityType(): Class<ProductRolstor> = ProductRolstor::class.java
}
