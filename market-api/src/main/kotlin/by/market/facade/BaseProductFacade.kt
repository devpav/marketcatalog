package by.market.facade

import by.market.domain.AbstractProduct
import by.market.domain.characteristics.AbstractCharacteristic
import by.market.domain.characteristics.ProductCharacteristic
import by.market.domain.system.Category
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.AbstractFrontEndProduct
import by.market.mapper.dto.ProductFilterFrontEnd
import by.market.mapper.dto.characteristics.FrontEndCharacteristicDescription
import by.market.mapper.dto.characteristics.FrontEndCharacteristicPair
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.services.abstraction.IProductService
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.hibernate.Session
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


open class BaseProductFacade<TDto : AbstractFrontEndProduct, TEntity : AbstractProduct>(entityService: IProductService<TEntity>,
                                                                                        mapper: IMapstructMapper<TDto, TEntity>,
                                                                                        protected val categoryMapper: IMapstructMapper<CategoryFrontEnd, Category>,
                                                                                        protected val session: Session)
    : IProductFacade<TDto>, AbstractFacade<IProductService<TEntity>, TDto, TEntity>(entityService, mapper) {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun findByCategory(category: CategoryFrontEnd): MutableList<TDto> {
        var databaseCategory = categoryMapper.from(category)
        val entitiesByCategory = entityService.findByCategory(databaseCategory)
        return mapper.to(entitiesByCategory).toMutableList()
    }

    override fun findCharacteristicByProduct(dto: TDto): FrontEndCharacteristicPair {
        return runBlocking {
            val doubleCharacteristicTask = async { buildCharacteristicMap(entityService.findDoubleCharacteristicById(dto.id!!)) }
            val stringCharacteristicTask = async { buildCharacteristicMap(entityService.findStringCharacteristicById(dto.id!!)) }

            val doubleRes = doubleCharacteristicTask.await()
            val stringRes = stringCharacteristicTask.await()

            FrontEndCharacteristicPair(
                    stringRes.map { FrontEndCharacteristicDescription(
                            it.key.title!!,
                            it.value.map { it.value!! }
                        )
                    },
                    doubleRes.map { FrontEndCharacteristicDescription(
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

    override fun findByFilter(filter: ProductFilterFrontEnd): MutableList<TDto> {
        session.createQuery(TEntity::class.java)
        return mutableListOf()
    }
}
