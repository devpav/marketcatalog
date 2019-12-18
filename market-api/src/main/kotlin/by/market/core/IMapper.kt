package by.market.core

interface IMapper<TFrom, TTo> {
    suspend fun map(value: TFrom): TTo
}
