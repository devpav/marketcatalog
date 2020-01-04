package by.market.parser.mapper.metadata

import by.market.domain.AbstractProduct
import by.market.domain.system.EntityMetadata
import by.market.repository.characteristic.single.DoubleSingleCharacteristicRepository
import by.market.repository.characteristic.single.StringSingleCharacteristicRepository
import org.slf4j.Logger
import org.springframework.transaction.annotation.Transactional
import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmName

open class MetadataRemover(private val mapEntityMetadata: Map<KClass<out AbstractProduct>, EntityMetadata>,
                           private val doubleCharRep: DoubleSingleCharacteristicRepository,
                           private val stringCharRep: StringSingleCharacteristicRepository,
                           private val logger: Logger) {

    @Transactional
    open suspend fun remove(product: AbstractProduct) {
        val metadata = mapEntityMetadata[product::class]
        if(metadata == null){
            logger.error("Not found category for class: ${product::class.jvmName}")
            return
        }

        if(product.id != null){
            val productId = product.id!!

            if(!doubleCharRep.existsByProductRowIdAndEntityMetadata(productId, metadata))
                doubleCharRep.deleteAllByProductRowIdAndEntityMetadata(productId, metadata)

            if(!stringCharRep.existsByProductRowIdAndEntityMetadata(productId, metadata))
                stringCharRep.deleteAllByProductRowIdAndEntityMetadata(productId, metadata)

        }
        else{
            logger.error("Not found id for product: ${product.title} CategoryId = ${product.category?.id}")
        }
    }
}
