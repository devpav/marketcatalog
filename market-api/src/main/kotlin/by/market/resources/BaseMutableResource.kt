package by.market.resources

import by.market.facade.Facade
import by.market.mapper.dto.BaseFrontEndEntity
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import java.util.*

abstract class BaseMutableResource<TDto: BaseFrontEndEntity, TFacade : Facade<TDto>>(facade: TFacade)
    : BaseReadonlyResource<TFacade, TDto>(facade), IMutableResource<TDto> {

    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<TDto>> {
        return ResponseEntity.ok(this.service.findAll(pageable).content.toMutableList())
    }

    override fun <S : TDto?> save(entity: S): ResponseEntity<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> saveAll(iterable: Iterable<S>): ResponseEntity<MutableList<S>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> saveAndFlush(entity: S): ResponseEntity<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(iterable: Iterable<TDto?>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteById(id: UUID) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(entity: TDto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteInBatch(iterable: Iterable<TDto?>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAllInBatch() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun flush() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
