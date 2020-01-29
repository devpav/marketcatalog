package by.market.repository.characteristic

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.repository.BaseRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractCharacteristicRepository<TEntity: AbstractCharacteristic<TEntityValue>,
        TEntityValue>
    : BaseRepository<TEntity> {
}
