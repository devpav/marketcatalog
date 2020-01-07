package by.market.services

import by.market.domain.AbstractProduct
import by.market.domain.system.Category
import by.market.repository.AbstractProductRepository
import by.market.services.abstraction.IProductService

abstract class BaseProductService<
        TEntity: AbstractProduct,
        TRepository: AbstractProductRepository<TEntity>
        >(rep: TRepository)
    : IProductService<TEntity>, BaseService<TEntity, TRepository>(rep){
    override fun findByCategory(category: Category): List<TEntity> {
        return rep.findByCategory(category)
    }
}
