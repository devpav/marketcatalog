package by.market.services.abstraction

import by.market.core.ProductFilter
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import by.market.services.IService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface IProductService<TEntity> : IService<TEntity> {

    fun findByCategory(category: UUID, pageable: Pageable): Page<TEntity>

    fun countByCategory(category: Category): Long

    fun findDoubleCharacteristicById(id: UUID): List<DoubleCharacteristic>

    fun findStringCharacteristicById(id: UUID): List<StringCharacteristic>

    fun findByFilter(filter: ProductFilter, pageable: Pageable): List<TEntity>

    fun countByFilter(filter: ProductFilter): Long

}
