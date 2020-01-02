package abstraction

import product_listener.EmptyProductListener

interface IProductParser<TProduct> {
  fun parse(context: IParserContext, listener: IProductListener<TProduct> = EmptyProductListener()): List<TProduct>
}
