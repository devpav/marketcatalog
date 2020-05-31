package by.market.resources.impl

import by.market.exception.database.EntityNotFoundException
import by.market.exception.database.RequestInNotValidException
import by.market.facade.Facade
import by.market.resources.IReadonlyResource
import by.market.resources.MutableResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

abstract class AbstractResource<TDTO, TFacade: Facade<TDTO>>(protected val facade: TFacade) : MutableResource<TDTO>, IReadonlyResource<TDTO> {

    @GetMapping
    override fun findAll(): ResponseEntity<MutableList<TDTO>> {
        return ResponseEntity.ok(facade.findAll())
    }

    @GetMapping("/page")
    override fun findPage(pageable: Pageable): ResponseEntity<Page<TDTO>> = ResponseEntity.ok(facade.findAll(pageable))

    @GetMapping("/{id}")
    override fun findById(@PathVariable("id") id: UUID): ResponseEntity<TDTO> {
        val entity = facade.findById(id)

        if (!entity.isPresent) {
            throw EntityNotFoundException("Entity not found with id [${id}]");
        }

        return ResponseEntity.ok(entity.get())
    }

    @PostMapping
    override fun save(@RequestBody entity: TDTO): ResponseEntity<TDTO> {
        if (entity == null) {
            throw RequestInNotValidException("Entity mustn't is NULL")
        }

        return ResponseEntity.ok(facade.save(entity))
    }

    @DeleteMapping("/{id}")
    override fun delete(@PathVariable("id") id: UUID): ResponseEntity<Unit> {
        facade.delete(id)

        return ResponseEntity.ok().build()
    }

    @DeleteMapping
    override fun deleteList(@RequestBody ids: MutableList<UUID>): ResponseEntity<Unit> {
        facade.delete(ids)

        return ResponseEntity.ok().build()
    }

}