package by.market.facade

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface Facade<DTO> {

    fun findAll(): MutableList<DTO>

    fun findAll(pageable: Pageable): Page<DTO>

    fun findById(id: UUID): Optional<DTO>

    fun saveAll(iterable: Iterable<DTO>): MutableList<DTO>

    fun save(entity: DTO): DTO

    fun deleteById(id: UUID): Unit

    fun deleteAll(iterable: Iterable<DTO?>): Unit

    fun deleteAll(): Unit

    fun existsById(id: UUID): Boolean

    fun count(): Long

}