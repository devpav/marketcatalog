package by.market.mapper.domain_dto_mapper.product

import by.market.domain.AbstractProduct
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.BaseEntityDTO
import org.mapstruct.Mapping

interface AbstractProductMapper<DTO: BaseEntityDTO, T: AbstractProduct>: IMapstructMapper<DTO, T> {

    override fun to(e: T): DTO

    @Mapping(target = "category", ignore = true)
    override fun from(d: DTO): T

}