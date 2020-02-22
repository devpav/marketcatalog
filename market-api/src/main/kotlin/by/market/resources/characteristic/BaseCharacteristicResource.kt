package by.market.resources.characteristic

import by.market.facade.Facade
import by.market.mapper.dto.BaseEntityDTO
import by.market.resources.AbstractResource

open class BaseCharacteristicResource<TFacade : Facade<TDto>, TDto: BaseEntityDTO>(facade: TFacade) : AbstractResource<TDto>(facade)
