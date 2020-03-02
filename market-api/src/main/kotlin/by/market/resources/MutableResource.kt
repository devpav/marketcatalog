package by.market.resources

import org.springframework.http.ResponseEntity
import java.util.*

interface MutableResource<TDTO> : IReadonlyResource<TDTO> {

    fun save(entity: TDTO): ResponseEntity<TDTO>

    fun saveAll(iterable: Iterable<TDTO>): ResponseEntity<MutableList<TDTO>>

    fun deleteAll(): ResponseEntity<Unit>

    fun deleteAll(iterable: Iterable<TDTO?>): ResponseEntity<Unit>

    fun delete(id: UUID): ResponseEntity<Unit>

}
