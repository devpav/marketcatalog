package by.market.mapper.dto

import by.market.mapper.dto.system.CategoryFrontEnd


open class AbstractFrontEndProduct : BaseFrontEndEntity() {

    var title: String? = null

    var img: String? = null

    var category: CategoryFrontEnd? = null

}
