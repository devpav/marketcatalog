package by.market.services.impl

import by.market.core.Constant
import by.market.domain.Product
import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.characteristics.Characteristic
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.EntityMetadata
import by.market.exception.database.EntityNotFoundException
import by.market.exception.database.RequestInNotValidException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class ProductValueService(private val productCharacteristicService: ProductCharacteristicService,
                               private val entityMetadataService: EntityMetadataService,
                               private val doubleSingleCharacteristicService: DoubleSingleCharacteristicService,
                               private val stringSingleCharacteristicService: StringSingleCharacteristicService) {

    @Transactional
    open fun save(entity: AbstractCharacteristic<Any>): AbstractCharacteristic<Any>? {
        val product = entity.product

        product ?: throw RequestInNotValidException("Entity must contain a product is not null")

        val characteristic = entity.characteristic

        characteristic ?: throw RequestInNotValidException("Entity must contain a characteristic is not null")

        val characteristicUUID = characteristic.id
        characteristicUUID ?: throw RequestInNotValidException("Characteristic entity must contain an id is not null")

        val foundOptionalCharacteristic = productCharacteristicService.findById(characteristicUUID)

        if (foundOptionalCharacteristic.isPresent.not()) {
            throw EntityNotFoundException("Characteristic entity with ID [${characteristicUUID}] not found")
        }

        val foundCharacteristic = foundOptionalCharacteristic.get()

        val dataType = foundCharacteristic.dataType

        dataType ?: throw EntityNotFoundException("Characteristic with ID $characteristicUUID doesn't contain DATA TYPE")

        return when (dataType.name) {
            Constant.DataType.Double -> {
                val entityMetadataDouble =
                        entityMetadataService.findByTableName(Constant.EntityMetadata.DoubleCharacteristic)

                val valueDoubleUnion = buildValueUnion(entity.value as Double, characteristic,
                        entityMetadataDouble, product)

                valueDoubleUnion.product

                val doubleObject: DoubleCharacteristic = DoubleCharacteristic()

                doubleObject.id = valueDoubleUnion.id
                doubleObject.product = valueDoubleUnion.product
                doubleObject.value = valueDoubleUnion.value
                doubleObject.entityMetadata = valueDoubleUnion.entityMetadata
                doubleObject.characteristic = valueDoubleUnion.characteristic



                return doubleSingleCharacteristicService.save(doubleObject) as AbstractCharacteristic<Any>
            }
            Constant.DataType.String -> {
                val entityMetadataString =
                        entityMetadataService.findByTableName(Constant.EntityMetadata.StringCharacteristic)

                val valueStringUnion =
                        buildValueUnion(entity.value as String, characteristic, entityMetadataString, product)

                var stringCharacteristic = stringSingleCharacteristicService.save(valueStringUnion as StringCharacteristic)
                return null
            }
            else -> throw EntityNotFoundException("Entity Metadata with table name [${dataType.name}] not found")
        }
    }

    private fun <T> buildValueUnion(value: T, characteristic: Characteristic, entityMetadata: EntityMetadata?, product: Product): AbstractCharacteristic<T> {
        val abstractCharacteristic: AbstractCharacteristic<T> = AbstractCharacteristic()

        abstractCharacteristic.value = value
        abstractCharacteristic.characteristic = characteristic
        abstractCharacteristic.entityMetadata = entityMetadata
        abstractCharacteristic.product = product

        return abstractCharacteristic

    }

}