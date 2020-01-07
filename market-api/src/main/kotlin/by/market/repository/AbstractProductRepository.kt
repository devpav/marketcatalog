package by.market.repository

import by.market.domain.AbstractProduct
import by.market.domain.system.Category
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractProductRepository<T: AbstractProduct> : BaseRepository<T> {

    fun existsByTitle(title: String): Boolean

    fun findByTitle(title: String): T

    fun findByCategory(category: Category): List<T>
}
