package by.market.services.characteristic

import by.market.domain.BaseEntity
import by.market.repository.BaseRepository

open class BaseSingleCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository) : BaseCharacteristicService<TEntity, TRepository>(rep)
