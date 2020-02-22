package by.market.facade

import by.market.ProductFilter
import by.market.dto.characteristics.CharacteristicPairDTO
import by.market.dto.system.CategoryDTO
import by.market.mapper.dto.AbstractProductDTO

interface IProductFacade<TDTO: AbstractProductDTO> : Facade<TDTO> {

    fun findByCategory(category: CategoryDTO): MutableList<TDTO>

    fun findCharacteristicByProduct(product: TDTO): CharacteristicPairDTO

    fun findByFilter(productFilter: ProductFilter): MutableList<TDTO>

}
