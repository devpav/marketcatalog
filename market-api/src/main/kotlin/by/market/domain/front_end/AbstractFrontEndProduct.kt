package by.market.domain.front_end

import by.market.domain.front_end.system.CategoryFrontEnd


open class AbstractFrontEndProduct : BaseFrontEndEntity() {

    var title: String? = null

    var img: String? = null

    var category: CategoryFrontEnd? = null

}
