package by.market.core

class ProjectMutableListIterator<TFrom, TTo>(
        private val inner: MutableListIterator<TFrom>,
        private val mapper: (TFrom) -> TTo,
        private val mapperTToToTFrom: (TTo) -> TFrom
) : MutableListIterator<TTo> {

    override fun hasPrevious(): Boolean = inner.hasPrevious()

    override fun nextIndex(): Int = inner.nextIndex()

    override fun previous(): TTo = mapper(inner.previous())

    override fun previousIndex(): Int = inner.previousIndex()

    override fun add(element: TTo) = inner.add(mapperTToToTFrom(element))

    override fun hasNext(): Boolean = inner.hasNext()

    override fun next(): TTo = mapper(inner.next())

    override fun remove() = inner.remove()

    override fun set(element: TTo) = inner.set(mapperTToToTFrom(element))
}
