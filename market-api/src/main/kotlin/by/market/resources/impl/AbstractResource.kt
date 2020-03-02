package by.market.resources.impl

import by.market.facade.Facade
import by.market.resources.IReadonlyResource
import by.market.resources.MutableResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

abstract class AbstractResource<TDTO>(protected val facade: Facade<TDTO>) : MutableResource<TDTO>, IReadonlyResource<TDTO> {

    @PostMapping
    override fun save(@RequestBody entity: TDTO): ResponseEntity<TDTO> {
        return ResponseEntity.ok(facade.save(entity))
    }

    @PostMapping("/array")
    override fun saveAll(@RequestBody iterable: Iterable<TDTO>): ResponseEntity<MutableList<TDTO>> {
        return ResponseEntity.ok(facade.saveAll(iterable))
    }

    @DeleteMapping("/all")
    override fun deleteAll(): ResponseEntity<Unit> {
        facade.deleteAll()

        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/iterate")
    override fun deleteAll(@RequestBody iterable: Iterable<TDTO?>): ResponseEntity<Unit> {

        facade.deleteAll(iterable)

        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    override fun delete(@PathVariable("id") id: UUID): ResponseEntity<Unit> {
        facade.deleteById(id)

        return ResponseEntity.ok().build()
    }

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<Page<TDTO>> {
        return ResponseEntity.ok(facade.findAll(pageable))
    }

    @GetMapping("/{id}")
    override fun findById(@PathVariable("id") id: UUID): ResponseEntity<TDTO> {
        val entity = facade.findById(id)

        if (!entity.isPresent) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(entity.get())
    }

    @GetMapping("/count")
    override fun count(): ResponseEntity<Long> {
        return ResponseEntity.ok(facade.count())
    }

}