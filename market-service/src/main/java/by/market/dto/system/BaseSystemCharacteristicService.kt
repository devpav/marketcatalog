package by.market.dto.system

import by.market.domain.BaseEntity
import by.market.repository.BaseRepository
import by.market.services.BaseService
import by.market.services.abstraction.ISystemService

open class BaseSystemCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : ISystemService<TEntity>, BaseService<TEntity, TRepository>(rep){
}
