package by.market.core.parser.mapper

import by.market.core.parser.mapper.metadata.CharacteristicMetadata
import by.market.domain.AbstractProduct
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.system.DataTypeRepository
import by.market.repository.system.EntityMetadataRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import parser.AsforosProduct
import javax.annotation.PostConstruct

@Component
class CharacteristicMapperHandler {

    private lateinit var characteristicMetadata: CharacteristicMetadata

    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var dataTypeRepository: DataTypeRepository
    @Autowired
    private lateinit var productCharacteristicRepository: ProductCharacteristicRepository
    @Autowired
    private lateinit var entityMetadataRepository: EntityMetadataRepository
    @Autowired
    private lateinit var doubleCharRep: DoubleSingleCharacteristicRepository
    @Autowired
    private lateinit var stringCharRep: StringSingleCharacteristicRepository

    @PostConstruct
    private fun init() {
        try {
            characteristicMetadata = CharacteristicMetadata(dataTypeRepository, entityMetadataRepository, productCharacteristicRepository, doubleCharRep, stringCharRep)
        }catch (e: Exception){
            logger.error("Error when Create CharacteristicMetadata", e)
            throw e
        }
    }

    fun <TProduct: AbstractProduct> handle(isNewProduct: Boolean, product: TProduct, parserProduct: AsforosProduct) {
        if(!isNewProduct) {
            try {
                characteristicMetadata.deleteCharacteristics(product)
            } catch (e: Exception) {
                logger.error("Error when deleteCharacteristics for Product [${product.id}, ${product.title}]", e)
            }
        }

        parserProduct.properties.forEach { entry ->
            try {
                characteristicMetadata.handleCharacteristic(product, entry.key, entry.value)
            }catch (e: Exception){
                logger.error("Error when handleCharacteristic properties for Product " +
                        "[${product.id}, ${product.title}] " +
                        "[characteristicName: ${entry.key}, value: ${entry.value}]", e)
            }
        }

        parserProduct.propertiesFromDetailPage.forEach { entry ->
            try {
                characteristicMetadata.handleCharacteristic(product, entry.key, entry.value)
            }catch (e: Exception){
                logger.error("Error when handleCharacteristic propertiesFromDetailPage for Product " +
                        "[${product.id}, ${product.title}] " +
                        "[characteristicName: ${entry.key}, value: ${entry.value}]", e)
            }
        }
    }
}

