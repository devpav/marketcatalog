package by.market.facade.impl

import by.market.core.ProductFilter
import by.market.domain.Product
import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.characteristics.Characteristic
import by.market.domain.system.Category
import by.market.dto.AbstractProductDTO
import by.market.dto.characteristics.CharacteristicDescriptionDTO
import by.market.dto.characteristics.CharacteristicPairDTO
import by.market.dto.system.CategoryDTO
import by.market.dto.system.ContentPage
import by.market.facade.IProductFacade
import by.market.mapper.MapstructMapper
import by.market.services.IProductService
import by.market.services.impl.CategoryService
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

open class BaseProductFacade<TDto : AbstractProductDTO, TEntity : Product>(entityService: IProductService<TEntity>, mapper: MapstructMapper<TDto, TEntity>)
    : IProductFacade<TDto>, AbstractFacade<IProductService<TEntity>, TDto, TEntity>(entityService, mapper) {

    @Autowired
    private lateinit var categoryMapper: MapstructMapper<CategoryDTO, Category>

    @Autowired
    private lateinit var categoryService: CategoryService

    override fun findByCategory(category: UUID, pageable: Pageable): Page<TDto> {
        val referenceCategory = categoryService.getReference(category)

        val page = entityService.findAllByCategory(referenceCategory, pageable);

        return page.map { mapper.toMap(it) }
    }

    override fun findCharacteristicByProduct(product: TDto): CharacteristicPairDTO {
        return runBlocking {
            val doubleCharacteristicTask = async {
                buildCharacteristicMap(entityService.findDoubleCharacteristicById(product.id!!))
            }

            val stringCharacteristicTask = async {
                buildCharacteristicMap(entityService.findStringCharacteristicById(product.id!!))
            }

            val doubleRes = doubleCharacteristicTask.await()
            val stringRes = stringCharacteristicTask.await()

            CharacteristicPairDTO(
                    stringRes.map { CharacteristicDescriptionDTO(
                            it.key.title!!,
                            it.value.map { it.value!! }
                        )
                    },
                    doubleRes.map { CharacteristicDescriptionDTO(
                            it.key.title!!,
                            it.value.map { it.value!! }
                        )
                    }
            )
        }
    }

    private fun <TVal, TCharacteristic: AbstractCharacteristic<TVal>> buildCharacteristicMap(characteristic: List<TCharacteristic>): Map<Characteristic, MutableList<TCharacteristic>> {
        val resMap = mutableMapOf<Characteristic, MutableList<TCharacteristic>>()
        characteristic.forEach {
            var characteristicMetadata = resMap[it.characteristic]

            if(characteristicMetadata == null){
                characteristicMetadata = mutableListOf()
                resMap[it.characteristic!!] = characteristicMetadata
            }

            characteristicMetadata.add(it)
        }

        return resMap
    }

    override fun findByFilter(productFilter: ProductFilter, category: UUID, pageable: Pageable): ContentPage<TDto> {
        val entitiesByFilter = this.entityService.findByFilter(productFilter, category, pageable)

        val dtosByFilter = entitiesByFilter.map { mapper.toMap(it) }.toMutableList()

        return ContentPage(dtosByFilter, entityService.countByFilter(productFilter, category), pageable.pageNumber, pageable.pageSize)
    }

}
