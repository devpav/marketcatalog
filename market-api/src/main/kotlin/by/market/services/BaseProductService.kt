package by.market.services

import by.market.domain.AbstractProduct
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import by.market.domain.system.EntityMetadata
import by.market.repository.AbstractProductRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.services.abstraction.IProductService
import java.util.*

abstract class BaseProductService<
        TEntity: AbstractProduct,
        TRepository: AbstractProductRepository<TEntity>
        >(rep: TRepository,
          protected val stringSingleCharacteristicRepository: StringSingleCharacteristicRepository,
          protected val doubleSingleCharacteristicRepository: DoubleSingleCharacteristicRepository)
    : IProductService<TEntity>, BaseService<TEntity, TRepository>(rep){

    private val lazyEntityMetadata: EntityMetadata by lazy {
        getEntityMetadata()
    }

    override fun findByCategory(category: Category): List<TEntity> {
        return rep.findByCategory(category)
    }

    override fun findDoubleCharacteristicById(id: UUID): List<DoubleCharacteristic> {
        return doubleSingleCharacteristicRepository.findByEntityMetadataAndRowId(lazyEntityMetadata, id)
    }

    override fun findStringCharacteristicById(id: UUID): List<StringCharacteristic> {
        return stringSingleCharacteristicRepository.findByEntityMetadataAndRowId(lazyEntityMetadata, id)
    }

    protected abstract fun getEntityMetadata(): EntityMetadata
}
