package by.market.services.impl

import by.market.domain.characteristics.Characteristic
import by.market.domain.system.DataType
import by.market.exception.database.EntityNotFoundException
import by.market.exception.database.RequestInNotValidException
import by.market.repository.characteristic.ProductCharacteristicRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class ProductCharacteristicService(repository: ProductCharacteristicRepository, private val dataTypeService: DataTypeService)
    : BaseCharacteristicService<Characteristic, ProductCharacteristicRepository>(repository) {

    @Transactional
    override fun save(entity: Characteristic): Characteristic {
        val dataTypeId = entity.dataType?.id

        if (entity.title.isNullOrEmpty())
            throw RequestInNotValidException("Title of characteristic mustn't be is NULL or EMPTY")

        dataTypeId ?: throw RequestInNotValidException("Data type and its ID mustn't be is NULL")

        val referenceDataType: DataType? = dataTypeService.getReference(dataTypeId)

        referenceDataType ?: throw EntityNotFoundException("Data type with ID [${dataTypeId}] not found")

        entity.dataType = referenceDataType

        return super.save(entity)
    }

}