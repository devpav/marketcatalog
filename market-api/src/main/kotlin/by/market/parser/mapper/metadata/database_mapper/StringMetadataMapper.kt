package by.market.parser.mapper.metadata.database_mapper

import by.market.domain.AbstractProduct
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.DataType
import by.market.domain.system.EntityMetadata
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import kotlin.reflect.KClass

open class StringMetadataMapper(productCharacteristicRepository: ProductCharacteristicRepository,
                           rep: StringSingleCharacteristicRepository,
                           entityMetadataMap: HashMap<KClass<out AbstractProduct>, EntityMetadata>,
                           type: DataType)
    : MetadataMapperBase<String, StringCharacteristic>(productCharacteristicRepository,
        rep,
        entityMetadataMap,
        type) {

    override fun stringToValue(values: String): String {
        return values
    }

    override fun makeDatabaseCharacteristic(): StringCharacteristic {
        return StringCharacteristic()
    }
}
