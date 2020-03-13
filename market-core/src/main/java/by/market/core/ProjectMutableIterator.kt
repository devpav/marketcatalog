package by.market.core

class ProjectMutableIterator<TFrom, TTo>(private val innerIterator: MutableIterator<TFrom>,
                                         private val mapper: (TFrom)-> TTo) : MutableIterator<TTo> {
    override fun hasNext(): Boolean = innerIterator.hasNext()

    override fun next(): TTo = mapper(innerIterator.next())

    override fun remove() = innerIterator.remove()

}
