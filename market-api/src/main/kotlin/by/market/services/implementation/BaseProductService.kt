package by.market.services.implementation

import by.market.domain.BaseEntity
import by.market.repository.BaseRepository

abstract class BaseProductService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : BaseService<TEntity, TRepository>(rep)
