package by.market.repository.product.Jinq

import by.market.domain.product.ProductJalousie
import by.market.repository.BaseJinqRepositoryImpl

import org.springframework.stereotype.Component

@Component
class JinqProductJalousieRepository : BaseJinqRepositoryImpl<ProductJalousie>() {
    override fun entityType(): Class<ProductJalousie> = ProductJalousie::class.java
}
