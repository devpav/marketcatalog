package by.market.resources

interface BaseResource<TEntity, TId> {

    public fun findById(id: TId): TEntity

    public fun findAll(): MutableCollection<TEntity>
}
