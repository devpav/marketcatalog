package by.market.facade

import by.market.core.ProductFilter
import by.market.dto.characteristics.CharacteristicPairDTO
import by.market.dto.system.CategoryDTO
import by.market.dto.system.ContentPage
import by.market.mapper.dto.AbstractProductDTO
import org.springframework.data.domain.Pageable

interface IProductFacade<TDTO: AbstractProductDTO> : Facade<TDTO> {

    fun findByCategory(category: CategoryDTO): ContentPage<TDTO>

    fun findCharacteristicByProduct(product: TDTO): CharacteristicPairDTO

    fun findByFilter(productFilter: ProductFilter, pageable: Pageable): ContentPage<TDTO>

}
