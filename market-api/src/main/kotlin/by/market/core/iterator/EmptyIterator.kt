package by.market.core.iterator

class EmptyIterator<T> : Iterator<T>, ListIterator<T>{
    override fun hasNext(): Boolean = false

    override fun hasPrevious(): Boolean = false

    override fun next(): T = throw IndexOutOfBoundsException()

    override fun nextIndex(): Int = -1

    override fun previous(): T = throw IndexOutOfBoundsException()

    override fun previousIndex(): Int = -1
}
