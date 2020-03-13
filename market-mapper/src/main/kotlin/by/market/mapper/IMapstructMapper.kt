package by.market.mapper

interface IMapstructMapper<TDto, TEntity> {

    fun to(e: TEntity): TDto
    fun from(d: TDto): TEntity

    fun to(e: Collection<TEntity>): Collection<TDto>
    fun from(d: Collection<TDto>): Collection<TEntity>

}
