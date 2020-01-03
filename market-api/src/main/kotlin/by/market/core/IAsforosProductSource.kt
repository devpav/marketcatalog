package by.market.core

import abstraction.IParserContext
import product.AsforosProduct

interface IAsforosProductSource {
    fun get(ctx: IParserContext): List<AsforosProduct>
}
