package by.market.facade.impl

import by.market.domain.BaseEntity
import by.market.dto.BaseEntityDTO
import by.market.mapper.MapstructMapper
import by.market.services.ISystemService

open class BaseSystemFacade<TDto : BaseEntityDTO, TEntity : BaseEntity, TService: ISystemService<TEntity>>(entityService: TService, mapper: MapstructMapper<TDto, TEntity>)
    : AbstractFacade<TService, TDto, TEntity>(entityService, mapper)