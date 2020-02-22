package by.market.core.parser.mapper.metadata.database_mapper

import by.market.domain.AbstractProduct
import by.market.domain.characteristics.AbstractSingleCharacteristic
import by.market.domain.characteristics.ProductCharacteristic
import by.market.domain.system.DataType
import by.market.domain.system.EntityMetadata
import by.market.repository.characteristic.AbstractSingleCharacteristicRepository
import by.market.repository.characteristic.ProductCharacteristicRepository
import org.springframework.transaction.annotation.Transactional
import kotlin.reflect.KClass

abstract class MetadataMapperBase<
        TValue,
        TCharacteristic: AbstractSingleCharacteristic<TValue>
        >(private val productCharacteristicRepository: ProductCharacteristicRepository,
          private val rep: AbstractSingleCharacteristicRepository<TCharacteristic, TValue>,
          private val entityMetadataMap: HashMap<KClass<out AbstractProduct>, EntityMetadata>,
          private val type: DataType)
    : IMetadataMapper {

    @Transactional
    override fun mapToDatabaseEntity(product: AbstractProduct, name: String, strValue: String) {
        val value = stringToValue(strValue)
        if(value != null) {
            val productValue = makeDatabaseCharacteristic()
            productValue.productRowId = product.id
            productValue.entityMetadata = entityMetadataMap[product::class]
            productValue.value = value
            productValue.productCharacteristic = saveProductCharacteristicIfNotExists(name, type)

            rep.save(productValue)
        }
    }

    @Transactional
    open fun saveProductCharacteristicIfNotExists(title: String, type: DataType): ProductCharacteristic {
        if(!productCharacteristicRepository.existsByTitleAndDataType(title, type)){
            val prCharacteristic = ProductCharacteristic()
            prCharacteristic.dataType = type
            prCharacteristic.title = title
            return productCharacteristicRepository.save(prCharacteristic)
        }

        return productCharacteristicRepository.findByTitleAndDataType(title, type)
    }

    abstract fun stringToValue(values: String): TValue?
    abstract fun makeDatabaseCharacteristic(): TCharacteristic
}
