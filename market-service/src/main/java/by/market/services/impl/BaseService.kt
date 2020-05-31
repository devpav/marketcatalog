package by.market.services.impl

import by.market.domain.BaseEntity
import by.market.repository.BaseRepository
import by.market.services.IService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

open class BaseService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(protected val rep: TRepository) : IService<TEntity> {

    override fun findAll(): MutableList<TEntity> = rep.findAll()

    override fun findAll(pageable: Pageable): Page<TEntity> = rep.findAll(pageable)

    override fun findById(id: UUID): Optional<TEntity> = rep.findById(id)

    override fun getReference(id: UUID): TEntity? =
        try {
            rep.getOne(id)
        } catch (ex: Exception) {
            null
        }

    override fun save(entity: TEntity): TEntity = rep.save(entity)

    override fun delete(id: UUID): Unit = rep.deleteById(id)

    override fun delete(ids: MutableList<UUID>): Unit {
        ids.forEach(this::delete)
    }

}
