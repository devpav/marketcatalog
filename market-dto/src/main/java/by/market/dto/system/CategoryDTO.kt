package by.market.dto.system

import by.market.mapper.dto.BaseEntityDTO
import java.util.*

class CategoryDTO : BaseEntityDTO() {

    var title: String? = null;

    var systemName: String? = null;

    var parent: UUID? = null

    var img: String? = null

}
