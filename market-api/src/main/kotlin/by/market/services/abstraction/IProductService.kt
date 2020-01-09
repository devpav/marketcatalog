package by.market.services.abstraction

import by.market.domain.system.Category

interface IProductService<TEntity> : IService<TEntity> {
    fun findByCategory(category: Category): List<TEntity>
}
