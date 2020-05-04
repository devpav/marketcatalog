package by.market.repository.product

import by.market.domain.Product
import by.market.domain.system.Category
import by.market.repository.BaseRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractProductRepository<TEntity : Product> : BaseRepository<TEntity> {

    fun findAllByCategory(category: Category, pageable: Pageable): Page<TEntity>

}