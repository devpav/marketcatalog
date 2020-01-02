package by.market.resources.implementation.system

import by.market.facade.system.ProductTypeFacade
import by.market.mapper.dto.system.ProductTypeFrontEnd
import by.market.resources.BaseMutableResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/product-type")
open class ProductTypeResource(facade: ProductTypeFacade)
    : BaseMutableResource<ProductTypeFrontEnd, ProductTypeFacade>(facade) {
    override fun <S : ProductTypeFrontEnd?> save(entity: S): ResponseEntity<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : ProductTypeFrontEnd?> saveAll(iterable: Iterable<S>): ResponseEntity<MutableList<S>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : ProductTypeFrontEnd?> saveAndFlush(entity: S): ResponseEntity<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(iterable: Iterable<ProductTypeFrontEnd?>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteById(id: UUID) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(entity: ProductTypeFrontEnd) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteInBatch(iterable: Iterable<ProductTypeFrontEnd?>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAllInBatch() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun flush() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
