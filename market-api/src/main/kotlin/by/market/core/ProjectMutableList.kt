package by.market.core

class ProjectMutableList<TFrom, TTo>(private val inner: MutableList<TFrom>,
                                     private val mapperFromTo: (TFrom) -> TTo,
                                     private val mapperToFrom: (TTo) -> TFrom) : MutableList<TTo> {
    override val size: Int
        get() = inner.size

    override fun contains(element: TTo): Boolean = inner.contains(mapperToFrom(element))

    override fun containsAll(elements: Collection<TTo>): Boolean = elements.all { contains(it) }

    override fun get(index: Int): TTo = mapperFromTo(inner[index])

    override fun indexOf(element: TTo): Int = inner.indexOf(mapperToFrom(element))

    override fun isEmpty(): Boolean = inner.isEmpty()

    override fun iterator(): MutableIterator<TTo> = ProjectMutableIterator(inner.iterator(), mapperFromTo)

    override fun lastIndexOf(element: TTo): Int = inner.lastIndexOf(mapperToFrom(element))

    override fun add(element: TTo): Boolean = inner.add(mapperToFrom(element))

    override fun add(index: Int, element: TTo) = inner.add(index, mapperToFrom(element))

    override fun addAll(index: Int, elements: Collection<TTo>): Boolean = inner.addAll(index, elements.map(mapperToFrom))

    override fun addAll(elements: Collection<TTo>): Boolean = inner.addAll(elements.map(mapperToFrom))

    override fun clear() = inner.clear()

    override fun listIterator(): MutableListIterator<TTo>
            = ProjectMutableListIterator(inner.listIterator(), mapperFromTo, mapperToFrom)

    override fun listIterator(index: Int): MutableListIterator<TTo>
            = ProjectMutableListIterator(inner.listIterator(index), mapperFromTo, mapperToFrom)

    override fun remove(element: TTo): Boolean = inner.remove(mapperToFrom(element))

    override fun removeAll(elements: Collection<TTo>): Boolean = inner.removeAll(elements.map(mapperToFrom))

    override fun removeAt(index: Int): TTo = mapperFromTo(inner.removeAt(index))

    override fun retainAll(elements: Collection<TTo>): Boolean = inner.retainAll(elements.map(mapperToFrom))

    override fun set(index: Int, element: TTo): TTo = mapperFromTo(inner.set(index, mapperToFrom(element)))

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<TTo>
            = ProjectMutableList(inner.subList(fromIndex, toIndex), mapperFromTo, mapperToFrom)
}
