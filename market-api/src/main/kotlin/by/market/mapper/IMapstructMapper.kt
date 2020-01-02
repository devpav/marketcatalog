package by.market.mapper

import by.market.domain.BaseEntity
import by.market.mapper.dto.BaseFrontEndEntity

interface IMapstructMapper<TDto: BaseFrontEndEntity, TEntity: BaseEntity> {

    fun to(e: TEntity): TDto
    fun from(d: TDto): TEntity

    fun to(e: Collection<TEntity>): Collection<TDto>
    fun from(d: Collection<TDto>): Collection<TEntity>

}
