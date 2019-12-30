package by.market.resources.implementation.characteristic

import by.market.facade.Facade
import by.market.mapper.dto.BaseFrontEndEntity

open class BaseSingleCharacteristicResource<TFacade : Facade<TDto>, TDto: BaseFrontEndEntity>(facade: TFacade)
    : BaseCharacteristicResource<TFacade, TDto>(facade)
