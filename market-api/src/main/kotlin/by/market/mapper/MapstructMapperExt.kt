package by.market.mapper

import by.market.domain.BaseEntity
import by.market.mapper.dto.BaseFrontEndEntity

fun <TDto : BaseFrontEndEntity, TEntity : BaseEntity> IMapstructMapper<TDto, TEntity>.fromDto(items: List<TDto>): List<TEntity> {
    return items.map { fromDto(it) }.toList()
}

fun <TDto : BaseFrontEndEntity, TEntity : BaseEntity> IMapstructMapper<TDto, TEntity>.toDto(items: List<TEntity>): List<TDto> {
    return items.map { toDto(it) }.toList()
}
