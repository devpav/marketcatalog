package by.market.facade.impl

import by.market.domain.BaseEntity
import by.market.dto.BaseEntityDTO
import by.market.facade.Facade
import by.market.mapper.MapstructMapper
import by.market.services.IService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

open class AbstractFacade<TService : IService<TEntity>, TDto : BaseEntityDTO, TEntity : BaseEntity>(
        protected val entityService: TService,
        protected val mapper: MapstructMapper<TDto, TEntity>) : Facade<TDto> {

    override fun findAll(): MutableList<TDto> {
        return mapper.toMap(entityService.findAll()).toMutableList()
    }

    override fun findAll(pageable: Pageable): Page<TDto> {
        val page  = entityService.findAll(pageable);

        return page.map { mapper.toMap(it) }
    }

    override fun findById(id: UUID): Optional<TDto> {
        return entityService.findById(id).map { mapper.toMap(it) }
    }

    override fun save(entity: TDto): TDto {
        val mappedEntity = mapper.fromMap(entity)
        val savedEntity = entityService.save(mappedEntity)
        return mapper.toMap(savedEntity)
    }

    override fun deleteById(id: UUID) {
        entityService.deleteById(id)
    }

}
