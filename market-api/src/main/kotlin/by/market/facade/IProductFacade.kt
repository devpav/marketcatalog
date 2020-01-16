package by.market.facade

import by.market.mapper.dto.AbstractFrontEndProduct
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.system.CategoryFrontEnd

interface IProductFacade<TDTO: AbstractFrontEndProduct> : Facade<TDTO> {
    fun findByCategory(category: CategoryFrontEnd): MutableList<TDTO>
    fun findCharacteristicByProduct(product: TDTO): FrontEndCharacteristicPair

    fun findByFilter(title: String): MutableList<TDTO>
}
