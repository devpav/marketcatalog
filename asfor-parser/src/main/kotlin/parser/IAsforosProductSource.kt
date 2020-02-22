package by.market.core

import parser.AsforosProduct
import parser.IParserContext

interface IAsforosProductSource {
    fun get(ctx: IParserContext): List<AsforosProduct>
}
