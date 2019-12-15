package by.market.parser.mapper

import by.market.domain.AbstractProduct
import by.market.domain.characteristics.AbstractSingleCharacteristic
import by.market.domain.characteristics.ProductCharacteristic
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.product.ProductAccessory
import by.market.domain.product.ProductBlind
import by.market.domain.product.ProductCornice
import by.market.domain.product.ProductCurtain
import by.market.domain.system.DataType
import by.market.domain.system.EntityMetadata
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.system.DataTypeRepository
import by.market.repository.system.EntityMetadataRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import product.AsforosProduct
import javax.annotation.PostConstruct

@Component
class CharacteristicMapperHandler {

    private lateinit var handlerMap: HashMap<String, CharacteristicMapperHolder>

    @Autowired
    private lateinit var dataTypeRepository: DataTypeRepository
    @Autowired
    private lateinit var productCharacteristicRepository: ProductCharacteristicRepository
    @Autowired
    private lateinit var entityMetadataRepository: EntityMetadataRepository

    @PostConstruct
    private fun init() {
        handlerMap = createCharacteristicMap()
    }

    suspend fun <TProduct: AbstractProduct> handle(product: TProduct, parserProduct: AsforosProduct) {
        val r = GlobalScope.async {
            val productCharacteristicHandler = async {
                parserProduct.properties.forEach { entry ->
                    val handler = handlerMap[entry.key]!!
                    handler.characteristicMapper(product, CharacteristicName(entry.key), CharacteristicValue(entry.value))
                }
            }

            val availableCharacteristicHandler = async {
                parserProduct.propertiesFromDetailPage.forEach { entry ->
                    val handler = handlerMap[entry.key]!!
                    entry.value.forEach {
                        run {
                            handler.characteristicMapper(product, CharacteristicName(entry.key), CharacteristicValue(it))
                        }
                    }
                }
            }

            productCharacteristicHandler.await()
            availableCharacteristicHandler.await()
        }

        r.await()
    }

    private fun createCharacteristicMap() : HashMap<String, CharacteristicMapperHolder> {
        val stringType = dataTypeRepository.findByName("STRING")
        val doubleType = dataTypeRepository.findByName("DOUBLE")

        val mapEntityMetadata: HashMap<String, EntityMetadata> = HashMap()
        mapEntityMetadata[ProductCornice::javaClass.name] = entityMetadataRepository.findByTableName("cornice")
        mapEntityMetadata[ProductBlind::javaClass.name] = entityMetadataRepository.findByTableName("blind")
        mapEntityMetadata[ProductCurtain::javaClass.name] = entityMetadataRepository.findByTableName("curtain")
        mapEntityMetadata[ProductAccessory::javaClass.name] = entityMetadataRepository.findByTableName("accessory")


        @Transactional
        fun <V, T : AbstractSingleCharacteristic<V>>characteristicMapper(product: AbstractProduct,
                                                                         productValue: T,
                                                                         name: CharacteristicName,
                                                                         type: DataType) {
            val productCharacteristic = ProductCharacteristic()
            productCharacteristic.dataType = type
            productCharacteristic.title = name.value

            productValue.productRowId = product.id
            productValue.entityMetadata = mapEntityMetadata[product::javaClass.name]
            productValue.productCharacteristic = productCharacteristic

            productCharacteristicRepository.save(productCharacteristic)
        }

        fun doubleCharacteristicMapper(product: AbstractProduct, name: CharacteristicName, values: CharacteristicValue) {
            val productValue = DoubleCharacteristic()
            productValue.value = values.value.toDouble()
            characteristicMapper(product, productValue, name, doubleType)
        }

        fun stringCharacteristicMapper(product: AbstractProduct, name: CharacteristicName, values: CharacteristicValue) {
            val productValue = StringCharacteristic()
            productValue.value = values.value
            characteristicMapper(product, productValue, name, stringType)
        }

        val result: HashMap<String, CharacteristicMapperHolder> = HashMap()

        result["Цвет"]                              = CharacteristicMapperHolder(::stringCharacteristicMapper)
        result["Артикул"]                           = CharacteristicMapperHolder(::stringCharacteristicMapper)
        result["Коллекция"]                         = CharacteristicMapperHolder(::stringCharacteristicMapper)
        result["Составной"]                         = CharacteristicMapperHolder(::stringCharacteristicMapper)
        result["Тип колец"]                         = CharacteristicMapperHolder(::stringCharacteristicMapper)
        result["Тип"]                               = CharacteristicMapperHolder(::stringCharacteristicMapper)
        result["ID поста блога для комментариев"]   = CharacteristicMapperHolder(::stringCharacteristicMapper)
        result["Тип трубы"]                         = CharacteristicMapperHolder(::stringCharacteristicMapper)

        result["Количество рядов"]                  = CharacteristicMapperHolder(::stringCharacteristicMapper)
        result["Ширина ленты (см)"]                 = CharacteristicMapperHolder(::doubleCharacteristicMapper)
        result["Ширина (см)"]                       = CharacteristicMapperHolder(::doubleCharacteristicMapper)
        result["Диаметр (мм)"]                      = CharacteristicMapperHolder(::doubleCharacteristicMapper)
        result["Диаметр (см)"]                      = CharacteristicMapperHolder(::doubleCharacteristicMapper)
        result["Длина (м)"]                         = CharacteristicMapperHolder(::doubleCharacteristicMapper)

        return result
    }

    class CharacteristicMapperHolder(val characteristicMapper: (product: AbstractProduct,
                                                                name: CharacteristicName, values:
                                                                CharacteristicValue) -> Unit)
}

inline class CharacteristicName(val value: String)
inline class CharacteristicValue(val value: String)
