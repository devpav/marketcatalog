package by.market.services.implementation.characteristic

import by.market.domain.BaseEntity
import by.market.repository.BaseRepository
import by.market.services.BaseService

open class BaseSingleCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : BaseCharacteristicService<TEntity, TRepository>(rep)
