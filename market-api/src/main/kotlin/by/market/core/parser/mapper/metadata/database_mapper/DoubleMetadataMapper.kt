package by.market.core.parser.mapper.metadata.database_mapper

import by.market.domain.AbstractProduct
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.system.DataType
import by.market.domain.system.EntityMetadata
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import kotlin.reflect.KClass

open class DoubleMetadataMapper(productCharacteristicRepository: ProductCharacteristicRepository,
                           rep: DoubleSingleCharacteristicRepository,
                           entityMetadataMap: HashMap<KClass<out AbstractProduct>, EntityMetadata>,
                           type: DataType)
    : MetadataMapperBase<Double, DoubleCharacteristic>(productCharacteristicRepository,
        rep,
        entityMetadataMap,
        type) {

    override fun stringToValue(values: String): Double? {
        return values.toDoubleOrNull()
    }

    override fun makeDatabaseCharacteristic(): DoubleCharacteristic {
        return DoubleCharacteristic()
    }
}
