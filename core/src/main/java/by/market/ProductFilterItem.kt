package by.market

import by.market.services.filter.model.FilterOperator
import java.util.*

data class ProductFilterItem(var id_charact: UUID, var value: List<String>, var type: FilterOperator)