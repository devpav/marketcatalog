package by.market.resources.system.implementation

import by.market.domain.BaseEntity
import by.market.resources.system.abstraction.IReadonlyResource
import by.market.services.abstraction.IService
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import java.util.*

open class BaseReadonlyResource<TService: IService<TEntity>, TEntity : BaseEntity>(protected val service: TService) : IReadonlyResource<TEntity> {
    override fun findAll(): ResponseEntity<MutableList<TEntity>> = ResponseEntity.ok(service.findAll());

    override fun findAll(sort: Sort): ResponseEntity<MutableList<TEntity>> = ResponseEntity.ok(service.findAll(sort));

    override fun findAll(pageable: Pageable): ResponseEntity<Page<TEntity>> = ResponseEntity.ok(service.findAll(pageable));

    override fun <S : TEntity?> findAll(example: Example<S>): ResponseEntity<MutableList<S>> = ResponseEntity.ok(service.findAll(example));

    override fun <S : TEntity?> findAll(example: Example<S>, sort: Sort): ResponseEntity<MutableList<S>> = ResponseEntity.ok(service.findAll(example, sort));

    override fun <S : TEntity?> findAll(example: Example<S>, pageable: Pageable): ResponseEntity<Page<S>>  = ResponseEntity.ok(service.findAll(example, pageable));

    override fun findAllById(iterable: Iterable<UUID?>): ResponseEntity<MutableList<TEntity>> = ResponseEntity.ok(service.findAllById(iterable));

    override fun <S : TEntity?> findOne(example: Example<S>): ResponseEntity<Optional<S>> = ResponseEntity.ok(service.findOne(example))

    override fun findById(id: UUID): ResponseEntity<Optional<TEntity>> = ResponseEntity.ok(service.findById(id))

    override fun getOne(id: UUID): ResponseEntity<BaseEntity> = ResponseEntity.ok(service.getOne(id))

    override fun <S : TEntity?> exists(example: Example<S>): ResponseEntity<Boolean> = ResponseEntity.ok(service.exists(example))

    override fun existsById(id: UUID): ResponseEntity<Boolean> = ResponseEntity.ok(service.existsById(id))

    override fun count(): ResponseEntity<Long> = ResponseEntity.ok(service.count())

    override fun <S : TEntity?> count(example: Example<S>): ResponseEntity<Long> = ResponseEntity.ok(service.count(example))
}
