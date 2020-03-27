package by.market.core

import java.util.*

data class ProductFilterItem(var id_charact: UUID, var value: List<String>, var type: FilterOperator)