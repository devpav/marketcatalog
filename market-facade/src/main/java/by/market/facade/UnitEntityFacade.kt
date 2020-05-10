package by.market.facade

import by.market.dto.UnitEntityDTO

interface UnitEntityFacade : Facade<UnitEntityDTO> {

    fun findByValue(value: String?): UnitEntityDTO

}