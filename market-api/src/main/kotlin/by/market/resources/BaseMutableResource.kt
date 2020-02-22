package by.market.resources

import by.market.core.facade.Facade
import by.market.mapper.dto.BaseFrontEndEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import java.util.*

abstract class BaseMutableResource<TDto: BaseFrontEndEntity, TFacade : Facade<TDto>>(facade: TFacade)
    : BaseReadonlyResource<TFacade, TDto>(facade) {

    override fun findAll(pageable: Pageable): ResponseEntity<Page<TDto>> {
        return ResponseEntity.ok(this.service.findAll(pageable))
    }

    override fun findById(id: UUID): ResponseEntity<Optional<TDto>> {
        val entity = this.service.findById(id).orElse(null) ?:
            return ResponseEntity.notFound().build()

        return ResponseEntity.ok(Optional.of(entity))
    }

    override fun count(): ResponseEntity<Long> {
        return ResponseEntity.ok(service.count());
    }
}
