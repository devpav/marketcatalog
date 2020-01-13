package by.market.facade

import by.market.mapper.dto.AbstractFrontEndProduct
import by.market.mapper.dto.ProductFilterFrontEnd
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.system.CategoryFrontEnd

interface IProductFacade<TDto: AbstractFrontEndProduct> : Facade<TDto> {
    fun findByCategory(category: CategoryFrontEnd): MutableList<TDto>
    fun findCharacteristicByProduct(product: TDto): FrontEndCharacteristicPair
    fun findByFilter(filter: ProductFilterFrontEnd): MutableList<TDto>
}
