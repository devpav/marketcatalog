package by.market.services.abstraction

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface IService<TEntity> {

    fun findAll(): MutableList<TEntity>

    fun findAll(pageable: Pageable): Page<TEntity>

    fun findById(id: UUID): Optional<TEntity>

    fun saveAll(iterable: Iterable<TEntity>): MutableList<TEntity>

    fun save(entity: TEntity): TEntity

    fun deleteById(id: UUID): Unit

    fun deleteAll(iterable: Iterable<TEntity?>): Unit

    fun deleteAll(): Unit

    fun existsById(id: UUID): Boolean

    fun count(): Long

}
