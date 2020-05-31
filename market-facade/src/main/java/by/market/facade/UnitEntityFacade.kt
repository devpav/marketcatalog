package by.market.facade

import by.market.dto.TreeUnitDTO
import by.market.dto.UnitEntityDTO

interface UnitEntityFacade : Facade<UnitEntityDTO> {

    fun findByValue(value: String?): UnitEntityDTO

    fun findUnitsTree(): MutableList<TreeUnitDTO>

    fun findGroups(): MutableList<UnitEntityDTO>

}