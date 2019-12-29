package by.market.core

import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher

class ProjectExample<TFrom, TTo>(private val inner: Example<TFrom>,
                                 private val mapper: (TFrom) -> TTo) : Example<TTo> {
    override fun getProbe(): TTo = mapper(inner.probe)

    override fun getMatcher(): ExampleMatcher = inner.matcher
}
