package by.market.resources

interface BaseResource<DTO, ID> {

    public fun findById(id: ID): DTO

    public fun findAll(): MutableCollection<DTO>
}
