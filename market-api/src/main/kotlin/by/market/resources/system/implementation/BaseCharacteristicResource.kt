package by.market.resources.system.implementation

import by.market.domain.BaseEntity
import by.market.services.abstraction.IService

open class BaseCharacteristicResource<TService : IService<TEntity>, TEntity: BaseEntity>(service: TService)
    : BaseMutableResource<TService, TEntity>(service)
