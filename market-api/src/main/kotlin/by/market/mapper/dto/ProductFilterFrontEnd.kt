package by.market.mapper.dto

import org.springframework.data.domain.Sort

data class ProductFilterFrontEnd(val name: String, val sort: Sort, val prop: Map<String, List<String>>)
