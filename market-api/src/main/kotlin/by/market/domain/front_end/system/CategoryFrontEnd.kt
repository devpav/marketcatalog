package by.market.domain.front_end.system

import by.market.domain.front_end.BaseFrontEndEntity

class CategoryFrontEnd : BaseFrontEndEntity() {

    var title: String? = null;

    var systemName: String? = null;

    var childCategory: CategoryFrontEnd? = null
}
