package by.market.resources

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

interface IMutableResource<TEntity> : IReadonlyResource<TEntity> {
    @GetMapping(value = ["/save/{entity}"])
    fun <S : TEntity?> save(@PathVariable("entity") entity: S): ResponseEntity<S>

    @GetMapping(value = ["/save-all/{entities}"])
    fun <S : TEntity?> saveAll(@PathVariable("entities") iterable: Iterable<S>): ResponseEntity<MutableList<S>>

    @GetMapping(value = ["/save-and-flush/{entity}"])
    fun <S : TEntity?> saveAndFlush(@PathVariable("entity") entity: S): ResponseEntity<S>

    @GetMapping(value = ["/delete-all"])
    fun deleteAll(): Unit

    @GetMapping(value = ["/delete-all/{entities}"])
    fun deleteAll(@PathVariable("entities") iterable: Iterable<TEntity?>): Unit

    @GetMapping(value = ["/delete/{id}"])
    fun deleteById(@PathVariable("id") id: UUID): Unit

    @GetMapping(value = ["/delete/{entity}"])
    fun delete(@PathVariable("entity") entity: TEntity): Unit

    @GetMapping(value = ["/delete-batch/{iterable}"])
    fun deleteInBatch(@PathVariable("iterable") iterable: Iterable<TEntity?>): Unit

    @GetMapping(value = ["/delete-all-batch"])
    fun deleteAllInBatch(): Unit

    @GetMapping(value = ["/flush"])
    fun flush(): Unit
}
