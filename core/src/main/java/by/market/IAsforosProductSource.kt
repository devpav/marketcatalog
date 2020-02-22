package by.market.core

import by.market.core.parser.AsforosProduct
import by.market.core.parser.IParserContext

interface IAsforosProductSource {
    fun get(ctx: IParserContext): List<AsforosProduct>
}
