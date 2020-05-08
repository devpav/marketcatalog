package by.market.resources

import org.springframework.http.ResponseEntity
import java.util.*

interface MutableResource<TDTO> : IReadonlyResource<TDTO> {

    fun save(entity: TDTO): ResponseEntity<TDTO>

    fun delete(id: UUID): ResponseEntity<Unit>

}
