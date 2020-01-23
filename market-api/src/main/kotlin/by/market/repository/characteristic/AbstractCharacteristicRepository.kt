package by.market.repository.characteristic

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.repository.BaseQuerydslRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface AbstractCharacteristicRepository<TEntity: AbstractCharacteristic<TEntityValue>,
        TEntityValue>
    : BaseQuerydslRepository<TEntity> {
}
