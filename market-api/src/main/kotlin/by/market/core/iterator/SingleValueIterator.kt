package by.market.core.iterator

class SingleValueIterator<T>(private val iter: T) : Iterator<T>, ListIterator<T>{

    private var hasNext: Boolean = true

    override fun hasNext(): Boolean = hasNext

    override fun next(): T {
        hasNext = false
        return iter
    }

    override fun hasPrevious(): Boolean = hasNext()

    override fun nextIndex(): Int = previousIndex()

    override fun previous(): T = next()

    override fun previousIndex(): Int {
        if(hasNext)
            return 0

        return -1
    }

}
