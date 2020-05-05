package by.market.services

import by.market.core.ProductFilter
import by.market.domain.Product
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface IProductService<TEntity: Product> : IService<TEntity> {

    fun findDoubleCharacteristicById(id: UUID): List<DoubleCharacteristic>

    fun findStringCharacteristicById(id: UUID): List<StringCharacteristic>

    fun findByFilter(filter: ProductFilter, category: UUID, pageable: Pageable): List<TEntity>

    fun countByFilter(filter: ProductFilter, category: UUID): Long

    fun findAllByCategory(category: Category?, pageable: Pageable): Page<TEntity>

}
