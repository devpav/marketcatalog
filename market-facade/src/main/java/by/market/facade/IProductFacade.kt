package by.market.facade

import by.market.core.ProductFilter
import by.market.dto.characteristics.CharacteristicPairDTO
import by.market.dto.system.ContentPage
import by.market.mapper.dto.AbstractProductDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface IProductFacade<TDTO: AbstractProductDTO> : Facade<TDTO> {

    fun findByCategory(category: UUID, pageable: Pageable): Page<TDTO>

    fun findCharacteristicByProduct(product: TDTO): CharacteristicPairDTO

    fun findByFilter(productFilter: ProductFilter, category: UUID, pageable: Pageable): ContentPage<TDTO>

}
