package by.market.repository.product

import by.market.domain.product.ProductAccessory
import by.market.repository.AbstractProductRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductAccessoryRepository : AbstractProductRepository<ProductAccessory> {

    override fun findAll(): MutableList<ProductAccessory>
}
