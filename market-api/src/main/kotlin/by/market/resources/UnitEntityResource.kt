package by.market.resources

import by.market.dto.TreeUnitDTO
import by.market.dto.UnitEntityDTO
import org.springframework.http.ResponseEntity

interface UnitEntityResource : MutableResource<UnitEntityDTO>, IReadonlyResource<UnitEntityDTO> {

    fun findByValue(value: String?): ResponseEntity<UnitEntityDTO>

    fun findUnitsTree(): ResponseEntity<MutableList<TreeUnitDTO>>

    fun findGroups(): ResponseEntity<MutableList<UnitEntityDTO>>

}