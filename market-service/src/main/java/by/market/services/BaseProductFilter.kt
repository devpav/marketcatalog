package by.market.services

import by.market.core.ProductFilter
import by.market.domain.BaseEntity
import org.springframework.data.domain.Pageable
import java.util.*

interface BaseProductFilter<T: BaseEntity> {

    fun findByFilter(filter: ProductFilter, category: UUID, pageable: Pageable): MutableList<T>;

    fun countByFilter(filter: ProductFilter, category: UUID): Long;

}