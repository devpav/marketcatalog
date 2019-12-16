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
import by.market.repository.characteristic.AbstractSingleCharacteristicRepository
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.system.DataTypeRepository
import by.market.repository.system.EntityMetadataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.springframework.transaction.annotation.Transactional

open class CharacteristicMetadata(private val dataTypeRepository: DataTypeRepository,
                                  private val entityMetadataRepository: EntityMetadataRepository,
                                  private val productCharacteristicRepository: ProductCharacteristicRepository,
                                  private val doubleCharRep: DoubleSingleCharacteristicRepository,
                                  private val stringCharRep: StringSingleCharacteristicRepository) {

    private val map: HashMap<String, CharacteristicMapperHolder>
    private val cleanupFunc: CleanupHandler

    init {
        val metadata = createCharacteristicMetadata()
        map = metadata.first
        cleanupFunc = metadata.second
    }

    fun <TProduct: AbstractProduct> handleCharacteristic(product: TProduct, characteristicName: String, value: String){
        val handler = map[characteristicName]!!
        handler.characteristicMapper(product, CharacteristicName(characteristicName), CharacteristicValue(value))
    }

    fun <TProduct: AbstractProduct> handleCharacteristic(product: TProduct, characteristicName: String, values: List<String>){
        val handler = map[characteristicName]!!
        values.forEach {
            handler.characteristicMapper(product, CharacteristicName(characteristicName), CharacteristicValue(it))
        }
    }

    suspend fun deleteCharacteristics(product: AbstractProduct){
        cleanupFunc.handler(product)
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

    @Transactional
    open fun <V, T : AbstractSingleCharacteristic<V>, TRep: AbstractSingleCharacteristicRepository<T, V>>
            saveCharacteristicValue(product: AbstractProduct,
                                    productValue: T,
                                    value: V,
                                    name: CharacteristicName,
                                    type: DataType,
                                    rep: TRep,
                                    entityMetadataMap: HashMap<String, EntityMetadata>) {
        productValue.productRowId = product.id
        productValue.entityMetadata = entityMetadataMap[product::javaClass.name]
        productValue.value = value
        productValue.productCharacteristic = saveProductCharacteristicIfNotExists(name.value, type)

        rep.save(productValue)
    }

    private fun createCharacteristicMetadata() : Pair<HashMap<String, CharacteristicMapperHolder>, CleanupHandler> {
        val stringType = dataTypeRepository.findByName("STRING")
        val doubleType = dataTypeRepository.findByName("DOUBLE")

        val mapEntityMetadata: HashMap<String, EntityMetadata> = HashMap()
        mapEntityMetadata[ProductCornice::javaClass.name] = entityMetadataRepository.findByTableName("cornice")
        mapEntityMetadata[ProductBlind::javaClass.name] = entityMetadataRepository.findByTableName("blind")
        mapEntityMetadata[ProductCurtain::javaClass.name] = entityMetadataRepository.findByTableName("curtain")
        mapEntityMetadata[ProductAccessory::javaClass.name] = entityMetadataRepository.findByTableName("accessory")

        fun doubleCharacteristicMapper(product: AbstractProduct, name: CharacteristicName, values: CharacteristicValue) {
            val productValue = DoubleCharacteristic()
            saveCharacteristicValue(product, productValue, values.value.toDouble(), name, doubleType, doubleCharRep, mapEntityMetadata)
        }

        fun stringCharacteristicMapper(product: AbstractProduct, name: CharacteristicName, values: CharacteristicValue) {
            val productValue = StringCharacteristic()
            saveCharacteristicValue(product, productValue, values.value, name, stringType, stringCharRep, mapEntityMetadata)
        }

        @Transactional
        suspend fun cleanup(product: AbstractProduct){
            val metadata = mapEntityMetadata[product.javaClass.name]!!
            withContext(Dispatchers.Default) {
                val cleanupSingleDouble = async {
                    if(!doubleCharRep.existsByRowIdAndMetadata(product.id!!, metadata))
                        doubleCharRep.deleteAllByRowIdAndMetadata(product.id!!, metadata)
                }

                val cleanupSingleString = async {
                    if(!stringCharRep.existsByRowIdAndMetadata(product.id!!, metadata))
                        stringCharRep.deleteAllByRowIdAndMetadata(product.id!!, metadata)
                }

                cleanupSingleDouble.await()
                cleanupSingleString.await()
            }
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

        return Pair(result, CleanupHandler(::cleanup))
    }

    class CharacteristicMapperHolder(val characteristicMapper: (product: AbstractProduct, name: CharacteristicName, values: CharacteristicValue) -> Unit)
    class CleanupHandler(val handler: suspend (product: AbstractProduct) -> Unit)
}

inline class CharacteristicName(val value: String)
inline class CharacteristicValue(val value: String)
