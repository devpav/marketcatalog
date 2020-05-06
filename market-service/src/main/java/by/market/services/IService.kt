package by.market.services

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface IService<TEntity> {

    fun findAll(): MutableList<TEntity>

    fun findAll(pageable: Pageable): Page<TEntity>

    fun findById(id: UUID): Optional<TEntity>

    fun getReference(id: UUID): TEntity?

    fun save(entity: TEntity): TEntity

    fun deleteById(id: UUID): Unit

}
