package by.market.resources.impl

import by.market.dto.UnitEntityDTO
import by.market.facade.UnitEntityFacade
import by.market.resources.UnitEntityResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/units")
open class UnitEntityResourceImpl(facade: UnitEntityFacade) : AbstractResource<UnitEntityDTO, UnitEntityFacade>(facade), UnitEntityResource {

    override fun findByValue(value: String?): ResponseEntity<UnitEntityDTO> = ResponseEntity.ok(facade.findByValue(value))

}