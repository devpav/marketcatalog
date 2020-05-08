package by.market.services.impl

import by.market.domain.Product
import by.market.domain.system.Category
import by.market.repository.product.AbstractProductRepository
import by.market.services.IProductService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

abstract class BaseProductService<TEntity: Product, TRepository: AbstractProductRepository<TEntity>>(repository: TRepository)
    : BaseService<TEntity, TRepository>(repository), IProductService<TEntity> {

    override fun findAllByCategory(category: Category?, pageable: Pageable): Page<TEntity> {
        return rep.findAllByCategory(category, pageable)
    }

}