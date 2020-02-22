package by.market.services.characteristic

import by.market.domain.BaseEntity
import by.market.repository.BaseRepository
import by.market.services.BaseService
import by.market.services.abstraction.ICharacteristicService

open class BaseCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository) : ICharacteristicService<TEntity>, BaseService<TEntity, TRepository>(rep)
