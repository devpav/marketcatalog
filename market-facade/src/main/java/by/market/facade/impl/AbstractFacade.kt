package by.market.facade.impl

import by.market.domain.BaseEntity
import by.market.dto.system.ContentPage
import by.market.facade.Facade
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.BaseEntityDTO
import by.market.services.IService
import org.springframework.data.domain.Pageable
import java.util.*

open class AbstractFacade<TService : IService<TEntity>, TDto : BaseEntityDTO, TEntity : BaseEntity>(
        protected val entityService: TService,
        protected val mapper: IMapstructMapper<TDto, TEntity>) : Facade<TDto> {

    override fun findAll(): ContentPage<TDto> {
        val mappedCollection = mapper.to(entityService.findAll()).toMutableList()

        val length = entityService.count()

        return ContentPage(mappedCollection, length)
    }

    override fun findAll(pageable: Pageable): ContentPage<TDto> {
        val page  = entityService.findAll(pageable);
        val mappedCollection = page.map { mapper.to(it) }.content

        val length = page.totalElements

        return ContentPage(mappedCollection, length, pageable.pageNumber, pageable.pageSize)
    }

    override fun findById(id: UUID): Optional<TDto> {
        return entityService.findById(id).map { mapper.to(it) }
    }

    override fun saveAll(iterable: Iterable<TDto>): MutableList<TDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(entity: TDto): TDto {
        return mapper.to(
                entityService.save(
                        mapper.from(entity)
                )
        )
    }

    override fun deleteById(id: UUID) {
        entityService.deleteById(id)
    }

    override fun deleteAll(iterable: Iterable<TDto?>) {
        entityService.deleteAll(iterable.mapNotNull { mapper.from(it!!) })
    }

    override fun deleteAll() {
        entityService.deleteAll()
    }

    override fun existsById(id: UUID): Boolean {
        return entityService.existsById(id)
    }

    override fun count(): Long {
        return entityService.count()
    }


}
