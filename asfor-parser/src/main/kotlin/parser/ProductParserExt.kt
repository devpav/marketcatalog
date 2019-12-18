package parser

import abstraction.IParserContext
import abstraction.IProductListener
import abstraction.IProductParser
import kotlinx.coroutines.runBlocking
import product.AsforosProduct
import product_listener.EmptyProductListener


fun <TProduct> IProductParser<TProduct>.parse(context: IParserContext,
                                              listener: IProductListener<TProduct> = EmptyProductListener()): List<TProduct>
 = runBlocking {
  parseAsync(context, listener).await()
}
