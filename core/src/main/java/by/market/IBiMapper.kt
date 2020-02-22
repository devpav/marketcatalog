package by.market.core

import arrow.core.Option

interface IBiMapper<TFrom, TTo> {
    fun fromTo(from: TFrom): Option<TTo>
    fun toFrom(to: TTo): Option<TFrom>
}
