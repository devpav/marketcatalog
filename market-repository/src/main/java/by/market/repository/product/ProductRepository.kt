package by.market.repository.product

import by.market.domain.Product
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : AbstractProductRepository<Product>
