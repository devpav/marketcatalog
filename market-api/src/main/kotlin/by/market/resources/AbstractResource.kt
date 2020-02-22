package by.market.resources

import by.market.facade.Facade
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

    @PostMapping
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
    override fun findAll(): ResponseEntity<MutableList<TDTO>> {
        return ResponseEntity.ok(facade.findAll())
    }

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<Page<TDTO>> {
        return ResponseEntity.ok(facade.findAll(pageable))
    }

    @GetMapping("/{id}")
    override fun findById(@PathVariable("id") id: UUID): ResponseEntity<TDTO> {
        return ResponseEntity.ok(facade.findById(id).orElse(null))
    }

    @GetMapping("/count")
    override fun count(): ResponseEntity<Long> {
        return ResponseEntity.ok(facade.count())
    }

}