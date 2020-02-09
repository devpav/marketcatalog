package by.market.parser.mapper.metadata

import by.market.domain.AbstractProduct
import by.market.domain.product.ProductAccessory
import by.market.domain.product.ProductCornice
import by.market.domain.product.ProductJalousie
import by.market.domain.product.ProductRolstor
import by.market.domain.system.EntityMetadata
import by.market.parser.mapper.metadata.database_mapper.DoubleMetadataMapper
import by.market.parser.mapper.metadata.database_mapper.IMetadataMapper
import by.market.parser.mapper.metadata.database_mapper.StringMetadataMapper
import by.market.repository.characteristic.ProductCharacteristicRepository
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.system.DataTypeRepository
import by.market.repository.system.EntityMetadataRepository
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

open class CharacteristicMetadata(private val dataTypeRepository: DataTypeRepository,
                                  private val entityMetadataRepository: EntityMetadataRepository,
                                  private val productCharacteristicRepository: ProductCharacteristicRepository,
                                  private val doubleCharRep: DoubleSingleCharacteristicRepository,
                                  private val stringCharRep: StringSingleCharacteristicRepository) {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val map: HashMap<String, IMetadataMapper>
    private val remover: MetadataRemover

    init {
        val metadata = createCharacteristicMetadata()
        map = metadata.first
        remover = metadata.second
    }

    fun <TProduct: AbstractProduct> handleCharacteristic(product: TProduct, characteristicName: String, value: String){
        val handler = map[characteristicName]
        if(handler != null) {
            handler.mapToDatabaseEntity(product, characteristicName, value)
        }
        else{
            logger.error("[handleCharacteristic] Not found characteristic mapper {}", characteristicName)
        }
    }

    fun <TProduct: AbstractProduct> handleCharacteristic(product: TProduct, characteristicName: String, values: List<String>){
        val handler = map[characteristicName]
        if(handler != null){
            values.forEach {
                handler.mapToDatabaseEntity(product, characteristicName, it)
            }
        }
        else{
            logger.error("[handleCharacteristic] Not found characteristic mapper {}", characteristicName)
        }
    }

    suspend fun deleteCharacteristics(product: AbstractProduct){
        remover.remove(product)
    }

    private fun createCharacteristicMetadata() : Pair<HashMap<String, IMetadataMapper>, MetadataRemover> {
        val mapEntityMetadata: HashMap<KClass<out AbstractProduct>, EntityMetadata> = HashMap()
        mapEntityMetadata[ProductCornice::class] = entityMetadataRepository.findByTableName("cornice")
        mapEntityMetadata[ProductRolstor::class] = entityMetadataRepository.findByTableName("rolstor")
        mapEntityMetadata[ProductAccessory::class] = entityMetadataRepository.findByTableName("accessory")
        mapEntityMetadata[ProductJalousie::class] = entityMetadataRepository.findByTableName("jalosie")

        val result: HashMap<String, IMetadataMapper> = HashMap()

        var stringMetadataMapper = StringMetadataMapper(productCharacteristicRepository, stringCharRep, mapEntityMetadata,
                dataTypeRepository.findByName("STRING"))

        var doubleMetadataMapper = DoubleMetadataMapper(productCharacteristicRepository, doubleCharRep, mapEntityMetadata,
                dataTypeRepository.findByName("DOUBLE"))

        result["Цвет"]                                  = stringMetadataMapper
        result["Артикул"]                               = stringMetadataMapper
        result["Коллекция"]                             = stringMetadataMapper
        result["Составной"]                             = stringMetadataMapper
        result["Тип колец"]                             = stringMetadataMapper
        result["Тип"]                                   = stringMetadataMapper
        result["ID поста блога для комментариев"]       = stringMetadataMapper
        result["Тип трубы"]                             = stringMetadataMapper
        result["Тип крепления"]                         = stringMetadataMapper
        result["Шина"]                                  = stringMetadataMapper

        result["Количество рядов"]                      = doubleMetadataMapper
        result["Ширина ленты (см)"]                     = doubleMetadataMapper
        result["Ширина (см)"]                           = doubleMetadataMapper
        result["Диаметр (мм)"]                          = doubleMetadataMapper
        result["Диаметр (см)"]                          = doubleMetadataMapper
        result["Длина (м)"]                             = doubleMetadataMapper
        result["Длина (см)"]                            = doubleMetadataMapper
        result["Ширина"]                                = doubleMetadataMapper

        val remover = MetadataRemover(mapEntityMetadata, doubleCharRep, stringCharRep, logger)
        return Pair(result, remover)
    }
}
