package by.market.services.impl

import by.market.domain.BaseEntity
import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.repository.BaseRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.services.ICharacteristicService
import org.springframework.stereotype.Service

open class BaseCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : ICharacteristicService<TEntity>, BaseService<TEntity, TRepository>(rep)

open class BaseSingleCharacteristicService<TCharacteristic, TEntity: AbstractCharacteristic<TCharacteristic>, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : BaseCharacteristicService<TEntity, TRepository>(rep)


@Service
open class DoubleSingleCharacteristicService(repository: DoubleSingleCharacteristicRepository)
    : BaseSingleCharacteristicService<Double, DoubleCharacteristic, DoubleSingleCharacteristicRepository>(repository)

@Service
open class StringSingleCharacteristicService(repository: StringSingleCharacteristicRepository)
    : BaseSingleCharacteristicService<String, StringCharacteristic, StringSingleCharacteristicRepository>(repository)

