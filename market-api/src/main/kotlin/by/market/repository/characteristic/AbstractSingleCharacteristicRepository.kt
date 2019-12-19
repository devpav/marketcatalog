package by.market.repository.characteristic

import by.market.domain.characteristics.AbstractSingleCharacteristic
import by.market.domain.system.EntityMetadata
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface AbstractSingleCharacteristicRepository<TEntity: AbstractSingleCharacteristic<TEntityValue>, TEntityValue>
    : AbstractCharacteristicRepository<TEntity, TEntityValue> {

    fun deleteAllByProductRowIdAndEntityMetadata(rowId: UUID, metadata: EntityMetadata): Boolean
    fun existsByProductRowIdAndEntityMetadata(rowId: UUID, metadata: EntityMetadata): Boolean

}
