package by.market.resources

import by.market.dto.system.ContentPage
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import java.util.*

interface IReadonlyResource<TDTO> {

    fun findAll(pageable: Pageable): ResponseEntity<ContentPage<TDTO>>

    fun findById(id: UUID): ResponseEntity<TDTO>

    fun count(): ResponseEntity<Long>

}
