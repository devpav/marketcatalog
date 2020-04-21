package by.market.facade.impl

import by.market.core.ProductFilter
import by.market.domain.AbstractProduct
import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.characteristics.ProductCharacteristic
import by.market.domain.system.Category
import by.market.dto.characteristics.CharacteristicDescriptionDTO
import by.market.dto.characteristics.CharacteristicPairDTO
import by.market.dto.system.CategoryDTO
import by.market.dto.system.ContentPage
import by.market.facade.IProductFacade
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.AbstractProductDTO
import by.market.services.abstraction.IProductService
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import java.util.*

open class BaseProductFacade<TDto : AbstractProductDTO, TEntity : AbstractProduct>(entityService: IProductService<TEntity>,
                                                                                   mapper: IMapstructMapper<TDto, TEntity>)
    : IProductFacade<TDto>, AbstractFacade<IProductService<TEntity>, TDto, TEntity>(entityService, mapper) {

    @Autowired
    private lateinit var categoryMapper: IMapstructMapper<CategoryDTO, Category>


    override fun findByCategory(category: String, pageable: Pageable): ContentPage<TDto> {
        val page = entityService.findByCategory(UUID.fromString(category), pageable);

        val toMutableList = mapper.to(page.content).toMutableList()

        return ContentPage(toMutableList, page.totalElements, pageable.pageNumber, pageable.pageSize)
    }

    override fun findCharacteristicByProduct(dto: TDto): CharacteristicPairDTO {
        return runBlocking {
            val doubleCharacteristicTask = async { buildCharacteristicMap(entityService.findDoubleCharacteristicById(dto.id!!)) }

            val stringCharacteristicTask = async { buildCharacteristicMap(entityService.findStringCharacteristicById(dto.id!!)) }

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

    private fun <TVal, TCharacteristic: AbstractCharacteristic<TVal>> buildCharacteristicMap(characteristic: List<TCharacteristic>): Map<ProductCharacteristic, MutableList<TCharacteristic>> {
        val resMap = mutableMapOf<ProductCharacteristic, MutableList<TCharacteristic>>()
        characteristic.forEach {
            var characteristicMetadata = resMap[it.productCharacteristic]

            if(characteristicMetadata == null){
                characteristicMetadata = mutableListOf()
                resMap[it.productCharacteristic!!] = characteristicMetadata
            }

            characteristicMetadata.add(it)
        }

        return resMap
    }

    override fun findByFilter(productFilter: ProductFilter, pageable: Pageable): ContentPage<TDto> {
        val toMutableList = this.entityService.findByFilter(productFilter, pageable)
                .map { mapper.to(it) }
                .toMutableList()

        return ContentPage(toMutableList, entityService.countByFilter(productFilter), pageable.pageNumber, pageable.pageSize)
    }
}
