package by.market.facade.impl

import by.market.domain.BaseEntity
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.BaseEntityDTO
import by.market.services.abstraction.ISystemService

open class BaseSystemFacade<TDto : BaseEntityDTO, TEntity : BaseEntity, TService: ISystemService<TEntity>>(entityService: TService, mapper: IMapstructMapper<TDto, TEntity>)
    : AbstractFacade<TService, TDto, TEntity>(entityService, mapper)