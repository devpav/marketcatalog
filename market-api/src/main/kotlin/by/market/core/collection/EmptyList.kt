package by.market.core.collection

import by.market.core.iterator.EmptyIterator

class EmptyList<T> : List<T> {
    override val size: Int
        get() = 0

    override fun contains(element: T): Boolean = false

    override fun containsAll(elements: Collection<T>): Boolean = false

    override fun get(index: Int): T = throw IndexOutOfBoundsException()

    override fun indexOf(element: T): Int = -1

    override fun isEmpty(): Boolean = true

    override fun iterator(): Iterator<T> = EmptyIterator()

    override fun lastIndexOf(element: T): Int = -1

    override fun listIterator(): ListIterator<T> = EmptyIterator()

    override fun listIterator(index: Int): ListIterator<T> = EmptyIterator()

    override fun subList(fromIndex: Int, toIndex: Int): List<T> {
        if(fromIndex == 0 && toIndex == 0)
            return this

        throw IndexOutOfBoundsException()
    }

}
