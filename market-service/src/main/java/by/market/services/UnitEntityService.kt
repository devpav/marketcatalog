package by.market.services

import by.market.domain.units.UnitEntity

interface UnitEntityService : IService<UnitEntity> {

    fun findByValue(value: String?): UnitEntity?

}