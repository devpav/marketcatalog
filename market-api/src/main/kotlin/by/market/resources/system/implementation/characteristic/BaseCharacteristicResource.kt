package by.market.resources.system.implementation.characteristic

import by.market.facade.Facade
import by.market.mapper.dto.BaseFrontEndEntity
import by.market.resources.system.implementation.BaseMutableResource

open class BaseCharacteristicResource<TFacade : Facade<TDto>, TDto: BaseFrontEndEntity>(facade: TFacade)
    : BaseMutableResource<TDto, TFacade>(facade)
