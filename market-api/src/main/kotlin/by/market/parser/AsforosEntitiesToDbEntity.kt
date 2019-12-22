package by.market.parser

import abstraction.IParserContext
import by.market.core.IMapper
import by.market.domain.AbstractProduct
import kotlinx.coroutines.runBlocking
import parser.AsforosProductParser
import parser.parse
import product.AsforosProduct

open class AsforosEntitiesToDbEntity<TProduct: AbstractProduct>(private val parser: AsforosProductParser,
                                                                private val context: IParserContext,
                                                                private val mapper: IMapper<AsforosProduct, TProduct>) {

    fun process() = runBlocking { parser.parse(context).forEach { mapper.map(it) } }

}
