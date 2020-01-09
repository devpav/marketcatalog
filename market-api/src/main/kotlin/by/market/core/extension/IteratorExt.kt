package by.market.core.extension

import by.market.core.collection.EmptyList
import by.market.core.collection.SingleValueList

fun <T> Iterable<T>.toSmartList(capacity: Int? = null): List<T> {
    if(this is List<T>){
        return this
    }

    return iterator().toSmartList(capacity)
}

fun <T> Iterator<T>.toSmartList(capacity: Int? = null): List<T> {
    if(!hasNext())
        return EmptyList()

    var item = next()

    if(!hasNext())
        return SingleValueList(item)

    val mutList = if(capacity != null) { ArrayList<T>(capacity) }else { ArrayList() }
    mutList.add(item)
    mutList.add(next())

    while (hasNext())
        mutList.add(next())

    return mutList
}
