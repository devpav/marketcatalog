package by.market.facade

import by.market.mapper.dto.AbstractFrontEndProduct
import by.market.mapper.dto.system.CategoryFrontEnd

interface IProductFacade<TDTO: AbstractFrontEndProduct> : Facade<TDTO> {
    fun findByCategory(category: CategoryFrontEnd): MutableList<TDTO>
}
