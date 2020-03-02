package utility

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import parser.IParserContext
import parser.IProductListener
import parser.IProductParser
import product_listener.EmptyProductListener

fun <T> IProductParser<T>.parseAsync(ctx: IParserContext, listener: IProductListener<T> = EmptyProductListener()): Deferred<List<T>> {
    return GlobalScope.async {
        parse(ctx, listener)
    }
}
