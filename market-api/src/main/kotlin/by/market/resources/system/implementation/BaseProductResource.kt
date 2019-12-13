package by.market.resources.system.implementation

import by.market.domain.AbstractProduct
import by.market.services.abstraction.IService

open class BaseProductResource<TService : IService<TEntity>, TEntity: AbstractProduct>(service: TService)
    : BaseMutableResource<TService, TEntity>(service)
