package by.market.resources

import by.market.domain.BaseEntity
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

interface IReadonlyResource<TEntity> {
    @GetMapping(value = ["/all"])
    fun findAll(): ResponseEntity<MutableList<TEntity>>

    @GetMapping(value = ["/all/{sort}"])
    fun findAll(@PathVariable("sort") sort: Sort): ResponseEntity<MutableList<TEntity>>

    @GetMapping(value = ["/all/{pageable}"])
    fun findAll(@PathVariable("pageable") pageable: Pageable): ResponseEntity<Page<TEntity>>

    @GetMapping(value = ["/all/{example}"])
    fun <S : TEntity?> findAll(@PathVariable("example") example: Example<S>): ResponseEntity<MutableList<S>>

    @GetMapping(value = ["/all/{example}/{sort}"])
    fun <S : TEntity?> findAll(@PathVariable("example") example: Example<S>,
                               @PathVariable("sort") sort: Sort): ResponseEntity<MutableList<S>>

    @GetMapping(value = ["/all/{example}/{pageable}"])
    fun <S : TEntity?> findAll(@PathVariable("example") example: Example<S>,
                               @PathVariable("pageable") pageable: Pageable): ResponseEntity<Page<S>>

    @GetMapping(value = ["/all/{entities}"])
    fun findAllById(@PathVariable("entities") iterable: Iterable<UUID?>): ResponseEntity<MutableList<TEntity>>

    @GetMapping(value = ["/find/{example}"])
    fun <S : TEntity?> findOne(@PathVariable("example") example: Example<S>): ResponseEntity<S>

    @GetMapping(value = ["/find/{id}"])
    fun findById(@PathVariable("id") id: UUID): ResponseEntity<TEntity>

    @GetMapping(value = ["/get-one/{id}"])
    fun getOne(@PathVariable("id") id: UUID): ResponseEntity<BaseEntity>

    @GetMapping(value = ["/exists/{example}"])
    fun <S : TEntity?> exists(@PathVariable("example") example: Example<S>): ResponseEntity<Boolean>

    @GetMapping(value = ["/exists/{id}"])
    fun existsById(@PathVariable("id") id: UUID): ResponseEntity<Boolean>

    @GetMapping(value = ["/count"])
    fun count(): ResponseEntity<Long>

    @GetMapping(value = ["/count/{example}"])
    fun <S : TEntity?> count(@PathVariable("example") example: Example<S>): ResponseEntity<Long>
}
