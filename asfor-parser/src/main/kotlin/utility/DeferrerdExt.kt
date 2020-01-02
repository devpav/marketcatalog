package utility

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

fun <T> Deferred<T>.unwrapSync(): T = runBlocking { await() }
