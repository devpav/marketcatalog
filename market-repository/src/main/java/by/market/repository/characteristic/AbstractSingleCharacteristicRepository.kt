package by.market.repository.characteristic

import by.market.domain.Product
import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.system.EntityMetadata
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractSingleCharacteristicRepository<TEntity: AbstractCharacteristic<TEntityValue>, TEntityValue> : AbstractCharacteristicRepository<TEntity, TEntityValue> {

    fun deleteAllByProductAndEntityMetadata(product: Product, metadata: EntityMetadata): Any

    fun existsByProductAndEntityMetadata(product: Product, metadata: EntityMetadata): Boolean

    fun findByEntityMetadataAndProduct(metadata: EntityMetadata, product: Product): List<TEntity>

    fun findByProductInAndEntityMetadata(ids: List<Product>, metadata: EntityMetadata): List<TEntity>

}
