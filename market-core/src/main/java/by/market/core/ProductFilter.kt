package by.market.core

class ProductFilter(var category: String, val filters: List<ProductFilterItem>, val page: Int? = 0, val size: Int? = 100)