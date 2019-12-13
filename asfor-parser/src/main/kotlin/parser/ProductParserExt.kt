package parser

import abstraction.IParserContext
import abstraction.IProductListener
import abstraction.IProductParser
import kotlinx.coroutines.runBlocking


fun <TProduct> IProductParser<TProduct>.parse(context: IParserContext, listener: IProductListener): List<TProduct>
 = runBlocking {
  parseAsync(context, listener).await()
}
