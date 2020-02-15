package by.market.resources

import by.market.domain.BaseEntity
import by.market.facade.Facade
import by.market.mapper.dto.BaseFrontEndEntity
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import java.util.*

open class BaseReadonlyResource<TFacade: Facade<TDto>, TDto : BaseFrontEndEntity>(protected val service: TFacade)
    : IReadonlyResource<TDto> {
    override fun findAll(): ResponseEntity<MutableList<TDto>> = ResponseEntity.ok(service.findAll())

    override fun findAll(sort: Sort): ResponseEntity<MutableList<TDto>>
            = ResponseEntity.ok(service.findAll(sort))

    override fun findAll(pageable: Pageable): ResponseEntity<Page<TDto>>
            = ResponseEntity.ok(service.findAll(pageable))

    override fun <S : TDto?> findAll(example: Example<S>): ResponseEntity<MutableList<S>>
            = ResponseEntity.ok(service.findAll(example))

    override fun <S : TDto?> findAll(example: Example<S>, sort: Sort): ResponseEntity<MutableList<S>>
            = ResponseEntity.ok(service.findAll(example, sort))

    override fun <S : TDto?> findAll(example: Example<S>, pageable: Pageable): ResponseEntity<Page<S>>
            = ResponseEntity.ok(service.findAll(example, pageable))

    override fun findAllById(iterable: Iterable<UUID?>): ResponseEntity<MutableList<TDto>>
        = ResponseEntity.ok(service.findAllById(iterable))

    override fun <S : TDto?> findOne(example: Example<S>): ResponseEntity<Optional<S>>
        = ResponseEntity.ok(service.findOne(example))

    override fun findById(id: UUID): ResponseEntity<Optional<TDto>>
        = ResponseEntity.ok(service.findById(id))

    override fun getOne(id: UUID): ResponseEntity<BaseEntity>
        = ResponseEntity.ok(service.getOne(id))

    override fun <S : TDto?> exists(example: Example<S>): ResponseEntity<Boolean>
        = ResponseEntity.ok(service.exists(example))

    override fun existsById(id: UUID): ResponseEntity<Boolean>
        = ResponseEntity.ok(service.existsById(id))

    override fun count(): ResponseEntity<Long>
        = ResponseEntity.ok(service.count())

    override fun <S : TDto?> count(example: Example<S>): ResponseEntity<Long>
        = ResponseEntity.ok(service.count(example))

}
