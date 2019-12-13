package abstraction

import kotlinx.coroutines.Deferred
import product_listener.EmptyProductListener

interface IProductParser<TProduct> {
  fun parseAsync(context: IParserContext, listener: IProductListener<TProduct> = EmptyProductListener()): Deferred<List<TProduct>>
}
