package by.market.mapper.dto.system

import by.market.mapper.dto.BaseFrontEndEntity

class CategoryFrontEnd : BaseFrontEndEntity() {

    var title: String? = null;

    var systemName: String? = null;

    var childCategory: CategoryFrontEnd? = null
}
