package by.market.services

import by.market.domain.BaseEntity
import by.market.repository.BaseRepository
import by.market.services.abstraction.IService
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*

open class BaseService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(protected val rep: TRepository)
    : IService<TEntity> {
    override fun findAll(): MutableList<TEntity> = rep.findAll()

    override fun findAll(sort: Sort): MutableList<TEntity> = rep.findAll(sort)

    override fun findAll(pageable: Pageable): Page<TEntity> = rep.findAll(pageable)

    override fun <S : TEntity?> findAll(example: Example<S>): MutableList<S> = rep.findAll(example)

    override fun <S : TEntity?> findAll(example: Example<S>, sort: Sort): MutableList<S> = rep.findAll(example, sort)

    override fun <S : TEntity?> findAll(example: Example<S>, pageable: Pageable): Page<S> = rep.findAll(example, pageable)

    override fun findAllById(iterable: Iterable<UUID?>): MutableList<TEntity> = rep.findAllById(iterable)

    override fun <S : TEntity?> findOne(example: Example<S>): Optional<S> = rep.findOne(example)

    override fun findById(id: UUID): Optional<TEntity> = rep.findById(id)

    override fun getOne(id: UUID): BaseEntity = rep.getOne(id)

    override fun <S : TEntity?> exists(example: Example<S>): Boolean = rep.exists(example)

    override fun existsById(id: UUID): Boolean = rep.existsById(id)

    override fun count(): Long = rep.count()

    override fun <S : TEntity?> count(example: Example<S>): Long = rep.count(example)
}
