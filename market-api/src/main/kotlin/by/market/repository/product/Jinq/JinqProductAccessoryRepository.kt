package by.market.repository.product.Jinq

import by.market.domain.product.ProductAccessory
import by.market.repository.BaseJinqRepositoryImpl
import org.springframework.stereotype.Repository

@Repository
class JinqProductAccessoryRepository : BaseJinqRepositoryImpl<ProductAccessory>() {
    override fun entityType(): Class<ProductAccessory> = ProductAccessory::class.java
}
