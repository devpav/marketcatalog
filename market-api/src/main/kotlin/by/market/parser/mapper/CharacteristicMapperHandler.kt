package by.market.parser.mapper

import by.market.domain.AbstractProduct
import by.market.parser.mapper.metadata.CharacteristicMetadata
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.system.DataTypeRepository
import by.market.repository.system.EntityMetadataRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import product.AsforosProduct
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

    suspend fun <TProduct: AbstractProduct> handle(isNewProduct: Boolean, product: TProduct, parserProduct: AsforosProduct) {
        val r = GlobalScope.async {
            if(!isNewProduct)
            {
                // Удалять необходимо до вставок!!!
                try {
                    characteristicMetadata.deleteCharacteristics(product)
                }catch (e: Exception){
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

        r.await()
    }
}

