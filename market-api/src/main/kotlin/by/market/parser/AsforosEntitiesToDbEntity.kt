package by.market.parser

import abstraction.IParserContext
import by.market.core.IMapper
import by.market.domain.AbstractProduct
import parser.AsforosProductParser
import parser.parse
import product.AsforosProduct

open class AsforosEntitiesToDbEntity<TProduct: AbstractProduct>(private val parser: AsforosProductParser,
                                                                private val context: IParserContext,
                                                                private val mapper: IMapper<AsforosProduct, TProduct>) {
    suspend fun process() {
        parser.parse(context).forEach {
            mapper.map(it)
        }
    }
}
