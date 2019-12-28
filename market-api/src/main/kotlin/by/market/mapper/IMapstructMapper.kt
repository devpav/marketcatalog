package by.market.mapper

import by.market.domain.BaseEntity
import by.market.mapper.dto.BaseFrontEndEntity
import org.mapstruct.MapperConfig
import org.mapstruct.ReportingPolicy

@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface IMapstructMapper<TDto: BaseFrontEndEntity, TEntity: BaseEntity> {
    fun toDto(e: TEntity): TDto
    fun fromDto(d: TDto): TEntity
}
