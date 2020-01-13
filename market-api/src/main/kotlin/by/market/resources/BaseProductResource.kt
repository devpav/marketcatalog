package by.market.resources

import by.market.facade.IProductFacade
import by.market.mapper.dto.AbstractFrontEndProduct
import by.market.mapper.dto.ProductFilterFrontEnd
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.system.CategoryFrontEnd
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

open class BaseProductResource<TFacade : IProductFacade<TDto>, TDto: AbstractFrontEndProduct>(service: TFacade)
    : BaseMutableResource<TDto, TFacade>(service) {

    @GetMapping(value = ["/findByCategory/{category}"])
    open fun findByCategory(@PathVariable("category")  category: CategoryFrontEnd): ResponseEntity<MutableList<TDto>> {
        return ResponseEntity.ok(service.findByCategory(category))
    }

    @GetMapping(value = ["/findByCategories/{categories}"])
    open fun findByCategories(@PathVariable("categories")  categories: List<CategoryFrontEnd>): ResponseEntity<MutableList<TDto>> {
        val res = categories.mapNotNull {
            findByCategory(it).body
        }
                .flatten()
                .toMutableList()

        return ResponseEntity.ok(res)
    }

    @GetMapping(value = ["/findByFilter/{filter}"])
    open fun findByFilter(@PathVariable("filter") filter: ProductFilterFrontEnd): ResponseEntity<MutableList<TDto>> {
        return ResponseEntity.ok(service.findByFilter(filter))
    }

    @GetMapping(value = ["/findCharacteristic/{product}"])
    open fun findCharacteristic(@PathVariable("product") product: TDto): ResponseEntity<FrontEndCharacteristicPair> {
        return ResponseEntity.ok(service.findCharacteristicByProduct(product))
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
