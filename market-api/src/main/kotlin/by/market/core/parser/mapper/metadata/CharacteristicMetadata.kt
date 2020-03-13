package by.market.core.parser.mapper.metadata

import arrow.core.Tuple4
import by.market.core.Constant
import by.market.core.parser.mapper.metadata.database_mapper.DoubleMetadataMapper
import by.market.core.parser.mapper.metadata.database_mapper.IMetadataMapper
import by.market.core.parser.mapper.metadata.database_mapper.StringMetadataMapper
import by.market.domain.AbstractProduct
import by.market.domain.product.ProductAccessory
import by.market.domain.product.ProductCornice
import by.market.domain.product.ProductJalousie
import by.market.domain.product.ProductRolstor
import by.market.domain.system.EntityMetadata
import by.market.extension.findDouble
import by.market.extension.findString
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
    private val stringMetadataMapper: StringMetadataMapper
    private val doubleMetadataMapper: DoubleMetadataMapper

    init {
        val metadata = createCharacteristicMetadata()
        map = metadata.a
        remover = metadata.b
        stringMetadataMapper = metadata.c
        doubleMetadataMapper = metadata.d
    }

    fun <TProduct: AbstractProduct> handleCharacteristic(product: TProduct, characteristicName: String, value: String){
        val handler = map[characteristicName]
        if(handler != null) {
            handler.mapToDatabaseEntity(product, characteristicName, value)
        }
        else{
            handleUnknownCharacteristic(product, characteristicName, value)
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
            values.forEach {
                handleUnknownCharacteristic(product, characteristicName, it)
            }
        }
    }

    private fun <TProduct: AbstractProduct> handleUnknownCharacteristic(product: TProduct, characteristicName: String, value: String) {
        // Если на сайте появились новые характеристики, обрабатываем их в ручную
        val doubleValue = value.toDoubleOrNull()
        if(doubleValue != null){
            doubleMetadataMapper.mapToDatabaseEntity(product, characteristicName, value)
        } else {
            stringMetadataMapper.mapToDatabaseEntity(product, characteristicName, value)
        }
    }

    fun deleteCharacteristics(product: AbstractProduct){
        remover.remove(product)
    }

    private fun createCharacteristicMetadata() : Tuple4<HashMap<String, IMetadataMapper>, MetadataRemover, StringMetadataMapper, DoubleMetadataMapper> {
        val mapEntityMetadata: HashMap<KClass<out AbstractProduct>, EntityMetadata> = HashMap()
        mapEntityMetadata[ProductCornice::class] = entityMetadataRepository.findByTableName(Constant.EntityMetadata.Cornice)
        mapEntityMetadata[ProductRolstor::class] = entityMetadataRepository.findByTableName(Constant.EntityMetadata.Rolstor)
        mapEntityMetadata[ProductAccessory::class] = entityMetadataRepository.findByTableName(Constant.EntityMetadata.Accessory)
        mapEntityMetadata[ProductJalousie::class] = entityMetadataRepository.findByTableName(Constant.EntityMetadata.Jalousie)

        val result: HashMap<String, IMetadataMapper> = HashMap()

        var stringMetadataMapper = StringMetadataMapper(productCharacteristicRepository, stringCharRep, mapEntityMetadata,
                dataTypeRepository.findString())

        var doubleMetadataMapper = DoubleMetadataMapper(productCharacteristicRepository, doubleCharRep, mapEntityMetadata,
                dataTypeRepository.findDouble())

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
        return Tuple4(result, remover, stringMetadataMapper, doubleMetadataMapper)
    }
}
