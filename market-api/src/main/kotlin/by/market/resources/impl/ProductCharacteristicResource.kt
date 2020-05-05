package by.market.resources.impl

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.system.Category
import by.market.domain.system.DataType
import by.market.domain.system.EntityMetadata
import by.market.dto.characteristics.AbstractCharacteristicDTO
import by.market.dto.characteristics.ProductCharacteristicDTO
import by.market.dto.characteristics.UniversalCharacteristicDTO
import by.market.dto.system.DataTypeDTO
import by.market.facade.impl.ProductCharacteristicFacade
import by.market.facade.impl.ProductCharacteristicValueFacade
import by.market.mapper.entity_metadata.EntityMetadataProductCharacteristicMapper
import by.market.mapper.entity_metadata.EntityMetadataProductTypeMapper
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import by.market.repository.system.CategoryRepository
import by.market.services.impl.ProductService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

@RestController
@RequestMapping("/api/product-characteristic")
class ProductCharacteristicResource(facade: ProductCharacteristicFacade) : AbstractResource<ProductCharacteristicDTO, ProductCharacteristicFacade>(facade){

    @Autowired private lateinit var stringCharacteristicRep: StringSingleCharacteristicRepository
    @Autowired private lateinit var doubleCharacteristicRep: DoubleSingleCharacteristicRepository
    @Autowired private lateinit var entityMetadataProductTypeMapper: EntityMetadataProductTypeMapper
    @Autowired private lateinit var entityMetadataProductCharacteristicMapper: EntityMetadataProductCharacteristicMapper
    @Autowired private lateinit var categoryRepository: CategoryRepository

    @Autowired private lateinit var productService: ProductService
    @Autowired private lateinit var productCharacteristicValueFacade: ProductCharacteristicValueFacade

    @PostMapping("/value")
    public fun saveCharacteristicValue(@RequestBody abstractCharacteristicDTO: AbstractCharacteristicDTO<Any>): ResponseEntity<AbstractCharacteristic<Any>?> {
        return ResponseEntity.ok(productCharacteristicValueFacade.save(abstractCharacteristicDTO)!!)
    }

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
    fun filter(@RequestParam("id") id: UUID): ResponseEntity<FilterCategory> {
        val categoryNullable: Optional<Category> = categoryRepository.findById(id)

        if(!categoryNullable.isPresent || categoryNullable.get().parentCategory == null)
            return ResponseEntity.of(Optional.empty())

        val findCategory = categoryNullable.get()

        val res = cachedFilter(findCategory).orElse(null)
        return ResponseEntity.ok(res)
    }

    @org.springframework.cache.annotation.Cacheable(value = ["characteristics"], key = "#findCategory")
    protected fun cachedFilter(findCategory: Category): Optional<FilterCategory> {
        val categoriesForFound = categoryRepository.findAllByParentCategory(findCategory)
                .map { it.id }
                .mapNotNull { it!! }
                .toMutableList()

        if(!findCategory.isParent)
            categoriesForFound.add(findCategory.id!!)

        if(categoriesForFound.count() == 0)
            return Optional.empty()

        val category = findCategory.parentCategory!!

        val parentEntityMetadata = entityMetadataProductCharacteristicMapper.toFrom(category).orNull()
                ?: return Optional.empty()

        val parentProductType = entityMetadataProductTypeMapper.fromTo(parentEntityMetadata).orNull()
                ?: return Optional.empty()

        val doubleMap: HashMap<UUID, CharacteristicValue> = HashMap()
        val stringMap: HashMap<UUID, CharacteristicValue> = HashMap()

        val entityIds = mutableListOf<UUID>()

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

        val result = (toUniversalCharacteristicFrontEnd(stringMap) + toUniversalCharacteristicFrontEnd(doubleMap))
                .toMutableList()

        return Optional.of(FilterCategory(findCategory.id, result));
    }

    class FilterCategory(val id: UUID?, val filter: MutableList<UniversalCharacteristicDTO>);

    private fun toUniversalCharacteristicFrontEnd(characteristic: HashMap<UUID, CharacteristicValue>): List<UniversalCharacteristicDTO> {
        return characteristic.map {
            val value = it.value
            return@map UniversalCharacteristicDTO(value.characteristic.id, value.characteristic.title, value.characteristic.dataType!!.name!!, value.values)
        }
    }

    private fun buildStringCharacteristic(rows: List<UUID>, metadata: EntityMetadata): List<Characteristic>{
        val products = rows.mapNotNull { productService.getReference(it) }.toMutableList()
        return stringCharacteristicRep.findByProductInAndEntityMetadata(products, metadata)
                .map { p ->
                    val dataTypeDTO = DataTypeDTO();
                    val characteristic = p.characteristic ?: return mutableListOf()
                    val dataType = characteristic.dataType ?: return mutableListOf()
                    dataTypeDTO.name = dataType.name
                    return@map Characteristic(characteristic.id!!, characteristic.title!!, dataType, p.value!!)
                }
    }

    private fun buildDoubleCharacteristic(rows: List<UUID>, metadata: EntityMetadata): List<Characteristic>{
        val products = rows.mapNotNull { productService.getReference(it) }.toMutableList()
        return doubleCharacteristicRep.findByProductInAndEntityMetadata(products, metadata)
                .map { p ->
                    return@map Characteristic(p.characteristic!!.id!!, p.characteristic!!.title!!, p.characteristic!!.dataType, p.value!!.toString())
                }
    }

    private data class Characteristic(val id: UUID, val title: String, val dataType: DataType?, val value: String)

    private data class CharacteristicValue(val  characteristic: Characteristic, val values: HashSet<String>)

}
