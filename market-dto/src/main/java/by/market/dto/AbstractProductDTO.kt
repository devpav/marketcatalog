package by.market.dto

import java.util.*


open class AbstractProductDTO : BaseEntityDTO() {

    var priceValue: Int? = null

    var title: String? = null

    var image: String? = null

    var category: UUID? = null

}
