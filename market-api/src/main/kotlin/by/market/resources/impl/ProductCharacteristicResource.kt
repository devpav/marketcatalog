package by.market.resources.impl

import by.market.core.ProductType
import by.market.domain.system.Category
import by.market.domain.system.EntityMetadata
import by.market.dto.characteristics.ProductCharacteristicDTO
import by.market.dto.characteristics.UniversalCharacteristicDTO
import by.market.dto.system.DataTypeDTO
import by.market.facade.impl.ProductCharacteristicFacade
import by.market.mapper.entity_metadata.EntityMetadataProductCharacteristicMapper
import by.market.mapper.entity_metadata.EntityMetadataProductTypeMapper
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.product.ProductAccessoryRepository
import by.market.repository.product.ProductCorniceRepository
import by.market.repository.product.ProductJalousieRepository
import by.market.repository.product.ProductRolstorRepository
import by.market.repository.system.CategoryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

@RestController
@RequestMapping("/api/product-characteristic")
class ProductCharacteristicResource(facade: ProductCharacteristicFacade) : AbstractResource<ProductCharacteristicDTO>(facade){

    @Autowired
    private lateinit var stringCharacteristicRep: StringSingleCharacteristicRepository
    @Autowired
    private lateinit var doubleCharacteristicRep: DoubleSingleCharacteristicRepository
    @Autowired
    private lateinit var accessoryRepository: ProductAccessoryRepository
    @Autowired
    private lateinit var corniceRepository: ProductCorniceRepository
    @Autowired
    private lateinit var jalousieRepository: ProductJalousieRepository
    @Autowired
    private lateinit var rolstorRepository: ProductRolstorRepository
    @Autowired
    private lateinit var entityMetadataProductTypeMapper: EntityMetadataProductTypeMapper
    @Autowired
    private lateinit var entityMetadataProductCharacteristicMapper: EntityMetadataProductCharacteristicMapper
    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    private fun fillCharacteristicMap(map: HashMap<UUID, CharacteristicValue>, characteristic: List<Characteristic>) {
        characteristic.forEach { sc ->
            val lst = map[sc.id]
            if(lst != null){
                lst.values.add(sc.value)
            }else{
                val set = HashSet<String>(5)
                set.add(sc.value)
                map[sc.id] = CharacteristicValue(sc, set)
            }
        }
    }

    @GetMapping("/filter")
    fun filter(id: String): ResponseEntity<MutableList<UniversalCharacteristicDTO>> {
        val findCategoryId = UUID.fromString(id)
        val categoryNullable = categoryRepository.findById(findCategoryId)
        if(!categoryNullable.isPresent || categoryNullable.get().parentCategory == null)
            return ResponseEntity.of(Optional.empty())

        val findCategory = categoryNullable.get()

        val res = cachedFilter(findCategory).orElse(mutableListOf())
        return ResponseEntity.ok(res)
    }

    @org.springframework.cache.annotation.Cacheable(value = ["characteristics"], key = "#findCategory")
    protected open fun cachedFilter(findCategory: Category): Optional<MutableList<UniversalCharacteristicDTO>> {
        val categoriesForFound = categoryRepository.findAllByParentCategory(findCategory)
                .map { it.id }
                .mapNotNull { it!! }
                .toMutableList()

        if(!findCategory.isParent)
            categoriesForFound.add(findCategory.id!!)

        if(categoriesForFound.count() == 0)
            return Optional.empty()

        val category = findCategory.parentCategory!!

        // Нужна родительская категория, чтобы определить тип сущности
        var parentEntityMetadata = entityMetadataProductCharacteristicMapper.toFrom(category).orNull()
        if(parentEntityMetadata == null)
            return Optional.empty()

        var parentProductType = entityMetadataProductTypeMapper.fromTo(parentEntityMetadata).orNull()
        if(parentProductType == null)
            return Optional.empty()

        val doubleMap: HashMap<UUID, CharacteristicValue> = HashMap()
        val stringMap: HashMap<UUID, CharacteristicValue> = HashMap()

        val entityIds = when(parentProductType) {
            ProductType.Accessories  -> accessoryRepository.getAllIdsByCategoryIds(categoriesForFound)
            ProductType.Cornice      -> corniceRepository.getAllIdsByCategoryIds(categoriesForFound)
            ProductType.Jalousie     -> jalousieRepository.getAllIdsByCategoryIds(categoriesForFound)
            ProductType.Rolstor      -> rolstorRepository.getAllIdsByCategoryIds(categoriesForFound)
        }

        GlobalScope.run {
            val stringAsync = async {
                val stringCharacteristic = buildStringCharacteristic(entityIds, parentEntityMetadata)
                fillCharacteristicMap(stringMap, stringCharacteristic)
            }

            val doubleAsync = async {
                val doubleCharacteristic = buildDoubleCharacteristic(entityIds, parentEntityMetadata)
                fillCharacteristicMap(doubleMap, doubleCharacteristic)
            }

            runBlocking {
                stringAsync.await()
                doubleAsync.await()
            }
        }

        val result = (toUniversalCharacteristicFrontEnd(stringMap) + toUniversalCharacteristicFrontEnd(doubleMap)).toMutableList()
        return Optional.of(result)
    }

    private fun toUniversalCharacteristicFrontEnd(characteristic: HashMap<UUID, CharacteristicValue>): List<UniversalCharacteristicDTO> {
        return characteristic.map {
            val value = it.value
            return@map UniversalCharacteristicDTO(value.characteristic.id, value.characteristic.title, value.characteristic.dataType, value.values)
        }
    }

    private fun buildStringCharacteristic(rows: List<UUID>, metadata: EntityMetadata): List<Characteristic>{
        return stringCharacteristicRep.findByProductRowIdInAndEntityMetadata(rows, metadata)
                .map { p ->
                    val dataTypeDTO = DataTypeDTO();
                    dataTypeDTO.name = p.productCharacteristic!!.dataType!!.name
                    return@map Characteristic(p.productCharacteristic!!.id!!, p.productCharacteristic!!.title!!, dataTypeDTO, p.value!!)
                }
    }

    private fun buildDoubleCharacteristic(rows: List<UUID>, metadata: EntityMetadata): List<Characteristic>{
        return doubleCharacteristicRep.findByProductRowIdInAndEntityMetadata(rows, metadata)
                .map { p ->
                    val dataTypeDTO = DataTypeDTO();
                    dataTypeDTO.name = p.productCharacteristic!!.dataType!!.name
                    return@map Characteristic(p.productCharacteristic!!.id!!, p.productCharacteristic!!.title!!, dataTypeDTO, p.value!!.toString())
                }
    }

    private data class Characteristic(val id: UUID, val title: String, val dataType: DataTypeDTO, val value: String)

    private data class CharacteristicValue(val characteristic: Characteristic, val values: HashSet<String>)

}
