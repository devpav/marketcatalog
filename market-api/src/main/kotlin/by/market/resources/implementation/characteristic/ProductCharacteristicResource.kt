package by.market.resources.implementation.characteristic

import arrow.core.getOrElse
import by.market.core.DataType
import by.market.core.ProductType
import by.market.domain.AbstractProduct
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.facade.characteristics.ProductCharacteristicFacade
import by.market.mapper.domain_dto_mapper.system.CategoryMapper
import by.market.mapper.dto.characteristics.ProductCharacteristicFrontEnd
import by.market.mapper.dto.characteristics.UniversalCharacteristicFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.mapper.entity_metadata.EntityMetadataProductCharacteristicMapper
import by.market.mapper.entity_metadata.EntityMetadataProductTypeMapper
import by.market.repository.characteristic.single.Jinq.JinqDoubleCharacteristicRepository
import by.market.repository.characteristic.single.Jinq.JinqStringCharacteristicRepository
import by.market.repository.product.Jinq.JinqProductAccessoryRepository
import by.market.repository.product.Jinq.JinqProductCorniceRepository
import by.market.repository.product.Jinq.JinqProductJalosieRepository
import by.market.repository.product.Jinq.JinqProductRolstorRepository
import by.market.repository.system.CategoryRepository
import org.jinq.jpa.JPAJinqStream
import org.jinq.orm.stream.JinqStream
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.HashMap

@RestController
@RequestMapping("/api/product-characteristic")
class ProductCharacteristicResource(facade: ProductCharacteristicFacade)
    : BaseCharacteristicResource<ProductCharacteristicFacade, ProductCharacteristicFrontEnd>(facade){
    @Autowired
    private lateinit var stringCharacteristicRep: JinqStringCharacteristicRepository
    @Autowired
    private lateinit var doubleCharacteristicRep: JinqDoubleCharacteristicRepository
    @Autowired
    private lateinit var accessoryRepository: JinqProductAccessoryRepository
    @Autowired
    private lateinit var corniceRepository: JinqProductCorniceRepository
    @Autowired
    private lateinit var jalosieRepository: JinqProductJalosieRepository
    @Autowired
    private lateinit var rolstorRepository: JinqProductRolstorRepository
    @Autowired
    private lateinit var entityMetadataProductTypeMapper: EntityMetadataProductTypeMapper
    @Autowired
    private lateinit var entityMetadataProductCharacteristicMapper: EntityMetadataProductCharacteristicMapper
    @Autowired
    private lateinit var categoryRepository: CategoryRepository
    @Autowired
    private lateinit var categoryMapper: CategoryMapper

    @GetMapping("/findCharacteristic")
    fun findByCategory(category: CategoryFrontEnd): ResponseEntity<MutableList<UniversalCharacteristicFrontEnd>> {
        val categoryDatabase = categoryMapper.from(category)
        val categories = categoryRepository.findAllByParentCategory(categoryDatabase)

        val entityMetadata = categories.map { entityMetadataProductCharacteristicMapper.toFrom(it).orNull() }
                .filterNotNull()
                .map { Pair(it, entityMetadataProductTypeMapper.fromTo(it).getOrElse { ProductType.Cornice }) }

        val doubleMap: HashMap<UUID, CharacteristicValue> = HashMap()
        val stringMap: HashMap<UUID, CharacteristicValue> = HashMap()

        entityMetadata.forEach {
            val metadata = it.first
            val characteristics = when(it.second) {
                ProductType.Accessories -> Pair(buildStringQuery(metadata, accessoryRepository.stream()), buildDoubleQuery(metadata, accessoryRepository.stream()))
                ProductType.Cornice     -> Pair(buildStringQuery(metadata, corniceRepository.stream()), buildDoubleQuery(metadata, corniceRepository.stream()))
                ProductType.Jalosie     -> Pair(buildStringQuery(metadata, jalosieRepository.stream()), buildDoubleQuery(metadata, jalosieRepository.stream()))
                ProductType.Rolstor     -> Pair(buildStringQuery(metadata, rolstorRepository.stream()), buildDoubleQuery(metadata, rolstorRepository.stream()))
            }

            characteristics.first.forEach { sc ->
                val lst = stringMap[sc.id]
                if(lst != null){
                    lst.values.add(sc.value)
                }else{
                    stringMap[sc.id] = CharacteristicValue(sc, mutableListOf(sc.value))
                }
            }

            characteristics.second.forEach { sc ->
                val lst = doubleMap[sc.id]
                if(lst != null){
                    lst.values.add(sc.value)
                }else{
                    doubleMap[sc.id] = CharacteristicValue(sc, mutableListOf(sc.value))
                }
            }
        }

        val result = (
                stringMap.map {
                    val value = it.value
                    return@map UniversalCharacteristicFrontEnd(value.characteristic.id,
                            value.characteristic.title,
                            value.characteristic.dataType,
                            value.values)
                }
                        +
                        doubleMap.map {
                            val value = it.value
                            return@map UniversalCharacteristicFrontEnd(value.characteristic.id,
                                    value.characteristic.title,
                                    value.characteristic.dataType,
                                    value.values)
                        }
                ).toMutableList()

        return ResponseEntity.ok(result)
    }

    private fun <T: AbstractProduct> buildStringQuery(entityMetadata: by.market.domain.system.EntityMetadata, stream: JPAJinqStream<T>): JPAJinqStream<Characteristic> {
        return stringCharacteristicRep.stream()
                .where(JinqStream.Where<StringCharacteristic, java.lang.Exception> { i ->
                    stream.where(JinqStream.Where<T, java.lang.Exception> { p -> p.id == i.productRowId }).findAny().isPresent
                            &&
                            i.entityMetadata!!.id == entityMetadata.id })
                .select { p -> Characteristic(p.productCharacteristic!!.id!!, p.productCharacteristic!!.title!!, DataType.String, p.value!!) }
    }

    private fun <T: AbstractProduct> buildDoubleQuery(entityMetadata: by.market.domain.system.EntityMetadata, stream: JPAJinqStream<T>): JPAJinqStream<Characteristic> {

        return doubleCharacteristicRep.stream()
                .where(JinqStream.Where<DoubleCharacteristic, java.lang.Exception> { i ->
                    stream.where(JinqStream.Where<T, java.lang.Exception> { p -> p.id == i.productRowId }).findAny().isPresent
                            &&
                            i.entityMetadata!!.id == entityMetadata.id })
                .select { p -> Characteristic(p.productCharacteristic!!.id!!, p.productCharacteristic!!.title!!, DataType.Double, p.value!!.toString()) }
    }

    private data class Characteristic(val id: UUID, val title: String, val dataType: DataType, val value: String)
    private data class CharacteristicValue(val characteristic: Characteristic, val values: MutableList<String>)
}
