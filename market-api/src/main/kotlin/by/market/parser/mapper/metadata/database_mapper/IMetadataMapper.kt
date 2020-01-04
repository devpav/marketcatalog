package by.market.parser.mapper.metadata.database_mapper

import by.market.domain.AbstractProduct
import org.springframework.transaction.annotation.Transactional

interface IMetadataMapper {
    @Transactional
    fun mapToDatabaseEntity(product: AbstractProduct, name: String, strValue: String)
}
