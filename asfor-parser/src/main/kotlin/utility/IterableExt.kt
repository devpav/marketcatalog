package utility

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

fun <T, TRes> Iterable<T>.mapAsync(m: (T) -> TRes): Iterable<Deferred<TRes>> {
    return this.map {
        GlobalScope.async {
            m(it)
        }
    }
}
