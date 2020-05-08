package by.market.dto

import java.util.*

class TreeCategoryDTO {
    var id: UUID? = null
    var title: String? = null
    var subcategory: MutableList<TreeCategoryDTO> = mutableListOf()
}