package by.market.facade

import by.market.core.ProjectMutableList
import by.market.core.ProjectPage
import by.market.domain.BaseEntity
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.BaseFrontEndEntity
import by.market.services.abstraction.IService
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*

open class AbstractFacade<TDto : BaseFrontEndEntity, TEntity
    : BaseEntity>(private val entityService: IService<TEntity>,
                  private val mapper: IMapstructMapper<TDto, TEntity>) : Facade<TDto> {

    override fun findAll(): MutableList<TDto> {
        return mapper.to(entityService.findAll()).toMutableList()
    }

    override fun findAll(sort: Sort): MutableList<TDto> {
        return mapper.to(entityService.findAll(sort)).toMutableList()
    }

    override fun findAll(pageable: Pageable): Page<TDto> {
        return ProjectPage(entityService.findAll(pageable)) { mapper.to(it) }
    }

    override fun <S : TDto?> findAll(example: Example<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(iterable: Iterable<UUID?>): MutableList<TDto> {
        return ProjectMutableList(entityService.findAllById(iterable), {mapper.to(it)}, {mapper.from(it)})
    }

    override fun <S : TDto?> findOne(example: Example<S>): Optional<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(id: UUID): Optional<TDto> {
        return entityService.findById(id).map { mapper.to(it) }
    }

    override fun getOne(id: UUID): BaseEntity {
        return entityService.getOne(id)
    }

    override fun <S : TDto?> save(entity: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> saveAll(iterable: Iterable<S>): MutableList<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> saveAndFlush(entity: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() = entityService.deleteAll()

    override fun deleteAll(iterable: Iterable<TDto?>) {
        return entityService.deleteAll(iterable.filterNotNull().map { mapper.from(it) })
    }

    override fun deleteById(id: UUID) = entityService.deleteById(id)

    override fun delete(entity: TDto) = entityService.delete(mapper.from(entity))

    override fun deleteInBatch(iterable: Iterable<TDto?>)  = entityService.deleteInBatch(iterable.filterNotNull().map{ mapper.from(it) })

    override fun deleteAllInBatch() = entityService.deleteAllInBatch()

    override fun flush() = entityService.flush()

    override fun <S : TDto?> exists(example: Example<S>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(id: UUID): Boolean = entityService.existsById(id)

    override fun count(): Long = entityService.count()

    override fun <S : TDto?> count(example: Example<S>): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
