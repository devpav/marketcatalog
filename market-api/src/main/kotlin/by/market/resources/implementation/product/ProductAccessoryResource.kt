package by.market.resources.implementation.product

import by.market.facade.product.ProductAccessoryFacade
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.product.ProductAccessoryFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.resources.BaseProductResource
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/accessory-product")
class ProductAccessoryResource(facade: ProductAccessoryFacade)
    : BaseProductResource<ProductAccessoryFacade, ProductAccessoryFrontEnd>(facade) {

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<MutableList<ProductAccessoryFrontEnd>> {
        return super.findAll(pageable)
    }

    @GetMapping
    override fun findByCategory(category: CategoryFrontEnd): ResponseEntity<MutableList<ProductAccessoryFrontEnd>> {
        return super.findByCategory(category)
    }

    @GetMapping
    override fun findCharacteristic(id: UUID): ResponseEntity<FrontEndCharacteristicPair> {
        return super.findCharacteristic(id)
    }
}
