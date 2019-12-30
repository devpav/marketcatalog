package by.market.resources.system.implementation.characteristic

import by.market.facade.Facade
import by.market.mapper.dto.BaseFrontEndEntity

open class BaseListCharacteristicResource<TFacade : Facade<TDto>, TDto: BaseFrontEndEntity>(service: TFacade)
    : BaseCharacteristicResource<TFacade, TDto>(service)
