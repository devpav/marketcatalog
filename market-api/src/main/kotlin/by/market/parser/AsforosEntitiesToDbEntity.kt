package by.market.parser

import abstraction.IParserContext
import abstraction.IProductListener
import by.market.core.IMapper
import by.market.domain.AbstractProduct
import kotlinx.coroutines.runBlocking
import parser.AsforosProductParser
import product.AsforosProduct
import product_listener.EmptyProductListener

open class AsforosEntitiesToDbEntity<TProduct: AbstractProduct>(private val parser: AsforosProductParser,
                                                                private val context: IParserContext,
                                                                private val mapper: IMapper<AsforosProduct, TProduct>) {

    fun process(listener: IProductListener<AsforosProduct> = EmptyProductListener()) = runBlocking {
        val parseProducts = parser.parse(context, listener)
        parseProducts.forEach {
            mapper.map(it)
        }
    }

}
