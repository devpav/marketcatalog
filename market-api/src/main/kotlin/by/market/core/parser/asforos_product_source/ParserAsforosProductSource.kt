package by.market.core.parser.asforos_product_source

import by.market.core.IAsforosProductSource
import parser.AsforosProduct
import parser.AsforosProductParser
import parser.IParserContext
import parser.IProductListener
import product_listener.EmptyProductListener

class ParserAsforosProductSource(private val listener: IProductListener<AsforosProduct> = EmptyProductListener()) : IAsforosProductSource {

    private val parser: AsforosProductParser = AsforosProductParser()

    override fun get(ctx: IParserContext): List<AsforosProduct> {
        return parser.parse(ctx, listener)
    }
}
