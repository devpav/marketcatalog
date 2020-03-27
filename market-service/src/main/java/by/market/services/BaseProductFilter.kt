package by.market.services

import by.market.core.ProductFilter
import by.market.domain.BaseEntity
import org.springframework.data.domain.Pageable

interface BaseProductFilter<T: BaseEntity> {

    fun findByFilter(filter: ProductFilter, pageable: Pageable): MutableList<T>;
    fun countByFilter(filter: ProductFilter): Long;

}