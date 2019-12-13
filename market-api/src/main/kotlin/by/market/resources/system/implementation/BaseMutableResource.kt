package by.market.resources.system.implementation

import by.market.domain.BaseEntity
import by.market.resources.system.abstraction.IMutableResource
import by.market.services.abstraction.IService
import org.springframework.http.ResponseEntity
import java.util.*

open class BaseMutableResource<TService : IService<TEntity>, TEntity: BaseEntity>(service: TService)
    : BaseReadonlyResource<TService, TEntity>(service), IMutableResource<TEntity> {
    override fun <S : TEntity?> save(entity: S): ResponseEntity<S> = ResponseEntity.ok(service.save(entity))

    override fun <S : TEntity?> saveAll(iterable: Iterable<S>): ResponseEntity<MutableList<S>> = ResponseEntity.ok(service.saveAll(iterable))

    override fun <S : TEntity?> saveAndFlush(entity: S): ResponseEntity<S> = ResponseEntity.ok(service.saveAndFlush(entity))

    override fun deleteAll() = service.deleteAll()

    override fun deleteAll(iterable: Iterable<TEntity?>) = service.deleteAll(iterable)

    override fun deleteById(id: UUID) = service.deleteById(id)

    override fun delete(entity: TEntity) = service.delete(entity)

    override fun deleteInBatch(iterable: Iterable<TEntity?>) = service.deleteInBatch(iterable)

    override fun deleteAllInBatch() = service.deleteAllInBatch()

    override fun flush() = service.flush()
}
