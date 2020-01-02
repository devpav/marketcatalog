package utility

import abstraction.IParserContext
import abstraction.IProductListener
import abstraction.IProductParser
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import product_listener.EmptyProductListener

fun <T> IProductParser<T>.parseAsync(ctx: IParserContext, listener: IProductListener<T> = EmptyProductListener()): Deferred<List<T>> {
    return GlobalScope.async {
        parse(ctx, listener)
    }
}
