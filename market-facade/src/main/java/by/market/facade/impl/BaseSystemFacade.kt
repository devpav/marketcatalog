package by.market.facade.impl

import by.market.domain.BaseEntity
import by.market.dto.BaseEntityDTO
import by.market.mapper.IMapstructMapper
import by.market.services.ISystemService

open class BaseSystemFacade<TDto : BaseEntityDTO, TEntity : BaseEntity, TService: ISystemService<TEntity>>(entityService: TService, mapper: IMapstructMapper<TDto, TEntity>)
    : AbstractFacade<TService, TDto, TEntity>(entityService, mapper)