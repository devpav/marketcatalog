package by.market.services.impl

import by.market.domain.BaseEntity
import by.market.domain.characteristics.ProductCharacteristic
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.repository.BaseRepository
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.services.abstraction.ICharacteristicService
import org.springframework.stereotype.Service

open class BaseCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : ICharacteristicService<TEntity>, BaseService<TEntity, TRepository>(rep)

open class BaseSingleCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : BaseCharacteristicService<TEntity, TRepository>(rep)


@Service
open class DoubleSingleCharacteristicService(repository: DoubleSingleCharacteristicRepository)
    : BaseSingleCharacteristicService<DoubleCharacteristic, DoubleSingleCharacteristicRepository>(repository)

@Service
open class ProductCharacteristicService(repository: ProductCharacteristicRepository)
    : BaseCharacteristicService<ProductCharacteristic, ProductCharacteristicRepository>(repository)

@Service
open class StringSingleCharacteristicService(repository: StringSingleCharacteristicRepository)
    : BaseSingleCharacteristicService<StringCharacteristic, StringSingleCharacteristicRepository>(repository)

