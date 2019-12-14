package by.market.repository.characteristic

import by.market.domain.characteristics.AbstractSingleCharacteristic
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractSingleCharacteristicRepository<TEntity: AbstractSingleCharacteristic<TEntityValue>, TEntityValue>
    : AbstractCharacteristicRepository<TEntity, TEntityValue> {
}
