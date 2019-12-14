package by.market.core

interface IMapper<TFrom, TTo> {
    fun map(value: TFrom): TTo
}
