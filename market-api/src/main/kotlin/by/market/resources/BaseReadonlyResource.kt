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
    override fun findAll(): ResponseEntity<MutableList<TDto>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(sort: Sort): ResponseEntity<MutableList<TDto>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(pageable: Pageable): ResponseEntity<Page<TDto>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> findAll(example: Example<S>): ResponseEntity<MutableList<S>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> findAll(example: Example<S>, sort: Sort): ResponseEntity<MutableList<S>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> findAll(example: Example<S>, pageable: Pageable): ResponseEntity<Page<S>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(iterable: Iterable<UUID?>): ResponseEntity<MutableList<TDto>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> findOne(example: Example<S>): ResponseEntity<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(id: UUID): ResponseEntity<TDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOne(id: UUID): ResponseEntity<BaseEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> exists(example: Example<S>): ResponseEntity<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(id: UUID): ResponseEntity<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(): ResponseEntity<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TDto?> count(example: Example<S>): ResponseEntity<Long> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
