package by.market.facade.impl

import by.market.domain.units.UnitEntity
import by.market.dto.UnitEntityDTO
import by.market.exception.database.RequestInNotValidException
import by.market.facade.UnitEntityFacade
import by.market.mapper.UnitEntityMapper
import by.market.services.UnitEntityService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class UnitEntityFacadeImpl(service: UnitEntityService, mapper: UnitEntityMapper)
    : AbstractFacade<UnitEntityService, UnitEntityDTO, UnitEntity>(service, mapper), UnitEntityFacade {

    override fun findByValue(value: String?): UnitEntityDTO {
        value ?: throw RequestInNotValidException("Value mustn't is NULL", HttpStatus.BAD_REQUEST)

        val unitEntity: UnitEntity? = entityService.findByValue(value)

        return mapper.toMap(unitEntity)
    }

}