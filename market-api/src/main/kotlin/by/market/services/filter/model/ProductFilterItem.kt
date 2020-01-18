package by.market.services.filter.model

import java.util.*

data class ProductFilterItem(var id_charact: UUID, var value: List<String>, var type: FilterOperator)