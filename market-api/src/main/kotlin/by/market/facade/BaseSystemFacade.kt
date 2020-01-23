package by.market.facade

import by.market.domain.BaseEntity
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.BaseFrontEndEntity
import by.market.services.abstraction.ISystemService

open class BaseSystemFacade<
        TDto : BaseFrontEndEntity,
        TEntity : BaseEntity,
        TService: ISystemService<TEntity>
        >(entityService: TService,
          mapper: IMapstructMapper<TDto, TEntity>) : AbstractFacade<TService, TDto, TEntity>(
        entityService,
        mapper) {
}
