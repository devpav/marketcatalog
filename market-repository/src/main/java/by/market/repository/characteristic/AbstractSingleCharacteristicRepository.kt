package by.market.repository.characteristic

import by.market.domain.characteristics.AbstractSingleCharacteristic
import by.market.domain.system.EntityMetadata
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface AbstractSingleCharacteristicRepository<TEntity: AbstractSingleCharacteristic<TEntityValue>, TEntityValue>
    : AbstractCharacteristicRepository<TEntity, TEntityValue> {

    fun deleteAllByProductRowIdAndEntityMetadata(productRowId: UUID, metadata: EntityMetadata): Any
    fun existsByProductRowIdAndEntityMetadata(productRowId: UUID, metadata: EntityMetadata): Boolean
    fun findByEntityMetadataAndProductRowId(metadata: EntityMetadata, productRowId: UUID): List<TEntity>
    fun findByProductRowIdInAndEntityMetadata(ids: List<UUID>, metadata: EntityMetadata): List<TEntity>
}
