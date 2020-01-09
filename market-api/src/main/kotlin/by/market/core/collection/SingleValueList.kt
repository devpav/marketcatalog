package by.market.core.collection

import by.market.core.iterator.SingleValueIterator

class SingleValueList<T>(private val value: T) : List<T> {
    override val size: Int
        get() = 1

    override fun contains(element: T): Boolean {
        return value != null && value == element
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return elements.all { contains(it) }
    }

    override fun get(index: Int): T {
        if (index == 0)
            return value

        throw IndexOutOfBoundsException()
    }

    override fun indexOf(element: T): Int {
        if(contains(element))
            return 0

        return -1
    }

    override fun isEmpty(): Boolean = false

    override fun iterator(): Iterator<T> = SingleValueIterator(value)

    override fun lastIndexOf(element: T): Int = indexOf(element)

    override fun listIterator(): ListIterator<T> = SingleValueIterator(value)

    override fun listIterator(index: Int): ListIterator<T> = SingleValueIterator(value)

    override fun subList(fromIndex: Int, toIndex: Int): List<T> {
        if(fromIndex == 0)
        {
            when (toIndex) {
                0 -> {
                    return EmptyList()
                }
                1 -> {
                    return this
                }
            }
        }

        throw IndexOutOfBoundsException()
    }

}
