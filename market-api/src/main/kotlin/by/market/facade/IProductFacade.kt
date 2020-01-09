package by.market.facade

import by.market.mapper.dto.AbstractFrontEndProduct
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.system.CategoryFrontEnd
import java.util.*

interface IProductFacade<TDTO: AbstractFrontEndProduct> : Facade<TDTO> {
    fun findByCategory(category: CategoryFrontEnd): MutableList<TDTO>
    fun findCharacteristicById(id: UUID): FrontEndCharacteristicPair
}
