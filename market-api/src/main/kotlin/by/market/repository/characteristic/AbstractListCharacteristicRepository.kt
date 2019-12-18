package by.market.repository.characteristic

import by.market.domain.characteristics.AbstractListCharacteristic
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractListCharacteristicRepository<TEntity: AbstractListCharacteristic<TEntityValue>, TEntityValue>
    : AbstractCharacteristicRepository<TEntity, TEntityValue> {
}
