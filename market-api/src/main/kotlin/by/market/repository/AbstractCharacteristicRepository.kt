package by.market.repository

import by.market.domain.characteristics.AbstractCharacteristic
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractCharacteristicRepository<TEntity: AbstractCharacteristic<TEntityValue>, TEntityValue> : BaseRepository<TEntity> {
}
