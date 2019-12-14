package by.market.parser.mapper

import by.market.domain.AbstractProduct
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import product.AsforosProduct

class CharacteristicMapperHandler {
    private val handlerMap: HashMap<String, CharacteristicMapperHolder> = createCharacteristicMap()

    // Определяем тип характеристики, и вставляем в БД, нельзя использовать мутабельные данные, могут вызывать из нескольких потоков!
    suspend fun <TProduct: AbstractProduct> handle(product: TProduct, parserProduct: AsforosProduct) {
        val r = GlobalScope.async {
            val productCharacteristicHandler = async {
                parserProduct.properties.forEach { entry ->
                    val handler = handlerMap[entry.key]!!
                    handler.characteristicMapper(product, CharacteristicName(entry.key), CharacteristicValue(entry.value))
                }
            }

            val availableCharacteristicHandler = async {
                parserProduct.propertiesFromDetailPage.forEach{ entry ->
                    val handler = handlerMap[entry.key]!!
                    handler.availableCharacteristicMapper(product, CharacteristicName(entry.key), CharacteristicValues(entry.value))
                }
            }

            productCharacteristicHandler.await()
            availableCharacteristicHandler.await()
        }

        r.await()
    }

    private fun createCharacteristicMap() : HashMap<String, CharacteristicMapperHolder> {
        fun stringCharacteristicMapper(product: AbstractProduct, name: CharacteristicName, values: CharacteristicValue) {
            TODO("Делаем вставку в 'tbx_ch_string_characteristic' привязывая к продукту")
        }

        fun doubleCharacteristicMapper(product: AbstractProduct, name: CharacteristicName, values: CharacteristicValue) {
            TODO("Делаем вставку в 'tbx_ch_double_characteristic' привязывая к продукту")
        }

        fun availableCharacteristicMapper(product: AbstractProduct, name: CharacteristicName, values: CharacteristicValues) {
            TODO("Если будем вставлять свойства в одну таблицу, можно сделать простой функцией")
        }

        val result: HashMap<String, CharacteristicMapperHolder> = HashMap<String, CharacteristicMapperHolder>()
        result["Цвет"] = CharacteristicMapperHolder(::stringCharacteristicMapper, ::availableCharacteristicMapper)
        result["Артикул"] = CharacteristicMapperHolder(::stringCharacteristicMapper, ::availableCharacteristicMapper)
        result["Коллекция"] = CharacteristicMapperHolder(::stringCharacteristicMapper, ::availableCharacteristicMapper)
        result["Составной"] = CharacteristicMapperHolder(::stringCharacteristicMapper, ::availableCharacteristicMapper)
        result["Тип колец"] = CharacteristicMapperHolder(::stringCharacteristicMapper, ::availableCharacteristicMapper)
        result["Тип"] = CharacteristicMapperHolder(::stringCharacteristicMapper, ::availableCharacteristicMapper)
        result["ID поста блога для комментариев"] = CharacteristicMapperHolder(::stringCharacteristicMapper, ::availableCharacteristicMapper)
        result["Тип трубы"] = CharacteristicMapperHolder(::stringCharacteristicMapper, ::availableCharacteristicMapper)

        result["Количество рядов"] = CharacteristicMapperHolder(::stringCharacteristicMapper, ::availableCharacteristicMapper)
        result["Ширина ленты (см)"] = CharacteristicMapperHolder(::doubleCharacteristicMapper, ::availableCharacteristicMapper)
        result["Ширина (см)"] = CharacteristicMapperHolder(::doubleCharacteristicMapper, ::availableCharacteristicMapper)
        result["Диаметр (мм)"] = CharacteristicMapperHolder(::doubleCharacteristicMapper, ::availableCharacteristicMapper)
        result["Диаметр (см)"] = CharacteristicMapperHolder(::doubleCharacteristicMapper, ::availableCharacteristicMapper)
        result["Длина (м)"] = CharacteristicMapperHolder(::doubleCharacteristicMapper, ::availableCharacteristicMapper)

        return result
    }

    // В значении будет лежать класс с функциями обработки, которые достают свойства и вставляет в БД
    class CharacteristicMapperHolder(val characteristicMapper: (product: AbstractProduct, name: CharacteristicName, values: CharacteristicValue) -> Unit,
                                     val availableCharacteristicMapper: (product: AbstractProduct, name: CharacteristicName, values: CharacteristicValues) -> Unit)
}

inline class CharacteristicName(val s: String)
inline class CharacteristicValue(val value: String)
inline class CharacteristicValues(val values: List<String>)
