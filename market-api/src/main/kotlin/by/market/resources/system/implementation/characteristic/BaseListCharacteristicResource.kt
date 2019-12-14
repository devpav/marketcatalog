package by.market.resources.system.implementation.characteristic

import by.market.domain.BaseEntity
import by.market.resources.system.implementation.BaseMutableResource
import by.market.services.abstraction.IService

open class BaseListCharacteristicResource<TService : IService<TEntity>, TEntity: BaseEntity>(service: TService)
    : BaseCharacteristicResource<TService, TEntity>(service)
