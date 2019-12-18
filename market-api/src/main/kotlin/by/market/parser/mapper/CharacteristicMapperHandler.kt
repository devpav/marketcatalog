package by.market.parser.mapper

import by.market.domain.AbstractProduct
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.system.DataTypeRepository
import by.market.repository.system.EntityMetadataRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import product.AsforosProduct
import javax.annotation.PostConstruct

@Component
class CharacteristicMapperHandler {

    private lateinit var characteristicMetadata: CharacteristicMetadata

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
        characteristicMetadata = CharacteristicMetadata(dataTypeRepository, entityMetadataRepository, productCharacteristicRepository, doubleCharRep, stringCharRep)
    }

    suspend fun <TProduct: AbstractProduct> handle(isNewProduct: Boolean, product: TProduct, parserProduct: AsforosProduct) {
        val r = GlobalScope.async {
            val cleanTask = async {
                if(!isNewProduct)
                    characteristicMetadata.deleteCharacteristics(product)
            }

            val productCharacteristicHandler = async {
                parserProduct.properties.forEach { entry ->
                    characteristicMetadata.handleCharacteristic(product, entry.key, entry.value)
                }
            }

            val availableCharacteristicHandler = async {
                parserProduct.propertiesFromDetailPage.forEach { entry ->
                    characteristicMetadata.handleCharacteristic(product, entry.key, entry.value)
                }
            }

            cleanTask.await()
            productCharacteristicHandler.await()
            availableCharacteristicHandler.await()
        }

        r.await()
    }
}

