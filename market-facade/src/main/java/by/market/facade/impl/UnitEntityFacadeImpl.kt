package by.market.facade.impl

import by.market.domain.units.UnitEntity
import by.market.dto.TreeUnitDTO
import by.market.dto.UnitEntityDTO
import by.market.exception.database.EntityNotFoundException
import by.market.exception.database.RequestInNotValidException
import by.market.facade.UnitEntityFacade
import by.market.mapper.UnitEntityMapper
import by.market.mapper.UnitEntityTreeMapper
import by.market.services.UnitEntityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class UnitEntityFacadeImpl(service: UnitEntityService, mapper: UnitEntityMapper)
    : AbstractFacade<UnitEntityService, UnitEntityDTO, UnitEntity>(service, mapper), UnitEntityFacade {

    @Autowired
    private lateinit var unitEntityTreeMapper: UnitEntityTreeMapper


    override fun findByValue(value: String?): UnitEntityDTO {
        value ?: throw RequestInNotValidException("Value mustn't is NULL", HttpStatus.BAD_REQUEST)

        val unitEntity: UnitEntity? = entityService.findByValue(value)

        unitEntity ?: throw EntityNotFoundException("Entity not found by value [$value]")

        return mapper.toMap(unitEntity)
    }

    override fun findUnitsTree(): MutableList<TreeUnitDTO> {
        val unitsTree = entityService.findUnitsTree()

        return unitEntityTreeMapper.toMap(unitsTree).toMutableList()
    }

}