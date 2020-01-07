package by.market.facade

import by.market.domain.BaseEntity
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.BaseFrontEndEntity
import by.market.services.abstraction.ISystemService

open class BaseSystemFacade<
        TDto : BaseFrontEndEntity,
        TEntity : BaseEntity
        >(entityService: ISystemService<TEntity>,
          mapper: IMapstructMapper<TDto, TEntity>) : AbstractFacade<ISystemService<TEntity>, TDto, TEntity>(
        entityService,
        mapper) {
}
