package by.market.core.parser.asforos_product_source

import abstraction.IParserContext
import abstraction.IProductListener
import by.market.core.IAsforosProductSource
import parser.AsforosProductParser
import product.AsforosProduct
import product_listener.EmptyProductListener

class ParserAsforosProductSource(private val listener: IProductListener<AsforosProduct> = EmptyProductListener()) : IAsforosProductSource {

    private val parser: AsforosProductParser = AsforosProductParser()

    override fun get(ctx: IParserContext): List<AsforosProduct> {
        return parser.parse(ctx, listener)
    }
}
