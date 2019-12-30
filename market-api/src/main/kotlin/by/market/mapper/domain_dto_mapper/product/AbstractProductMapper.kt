package by.market.mapper.domain_dto_mapper.product

import by.market.domain.AbstractProduct
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.BaseFrontEndEntity
import org.mapstruct.Mapping

interface AbstractProductMapper<DTO: BaseFrontEndEntity, T: AbstractProduct>: IMapstructMapper<DTO, T> {

    @Mapping(target = "category", ignore = true)
    override fun to(e: T): DTO

    override fun from(d: DTO): T

}