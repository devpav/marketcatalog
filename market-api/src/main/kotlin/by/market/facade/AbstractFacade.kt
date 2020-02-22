package by.market.facade

import by.market.core.ProjectMutableList
import by.market.domain.BaseEntity
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.BaseFrontEndEntity
import by.market.services.abstraction.IService
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*

open class AbstractFacade<TService : IService<TEntity>, TDto : BaseFrontEndEntity, TEntity
    : BaseEntity>(protected val entityService: TService,
                  protected val mapper: IMapstructMapper<TDto, TEntity>) : Facade<TDto> {

    override fun findAll(): MutableList<TDto> {
        return mapper.to(entityService.findAll()).toMutableList()
    }

    override fun findAll(sort: Sort): MutableList<TDto> {
        return mapper.to(entityService.findAll(sort)).toMutableList()
    }

    override fun findAll(pageable: Pageable): Page<TDto> {
        val entities: Page<TEntity> = entityService.findAll(pageable)
        return entities.map { mapper.to(it) }
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

    override fun <S : TDto?> exists(example: Example<S>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(id: UUID): Boolean = entityService.existsById(id)

    override fun count(): Long = entityService.count()

    override fun <S : TDto?> count(example: Example<S>): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
