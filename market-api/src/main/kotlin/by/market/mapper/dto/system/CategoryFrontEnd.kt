package by.market.mapper.dto.system

import by.market.mapper.dto.BaseFrontEndEntity
import java.util.*

class CategoryFrontEnd : BaseFrontEndEntity() {

    var title: String? = null;

    var systemName: String? = null;

    var child: UUID? = null
}
