package by.market.core

import java.util.*

data class ProductFilterItem(var characteristic: UUID, var value: List<String>, var type: FilterOperator)