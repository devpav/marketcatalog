package by.market.parser

import abstraction.IParserContext
import abstraction.IProductListener
import by.market.core.IMapper
import by.market.domain.AbstractProduct
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import parser.AsforosProductParser
import product.AsforosProduct

open class AsforosEntitiesToDbEntity<TProduct: AbstractProduct>(private val parser: AsforosProductParser,
                                                                private val context: IParserContext,
                                                                private val mapper: IMapper<AsforosProduct, TProduct>) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun process(listener: IProductListener<AsforosProduct> = LogListener(logger)) {
        var parseProducts: List<AsforosProduct>? = null
        try {
            parseProducts = parser.parse(context, listener)

            logger.info("After Parse {}", mapper.javaClass)
        }catch (ex: Exception) {
            logger.error("Error when parse ${mapper.javaClass}", ex)
            return
        }

        runBlocking{
            parseProducts.forEach {
                try {
                    mapper.map(it)
                }catch (e: Exception) {
                    logger.error("Error when map AsforosProduct to Database Entity Mapper[${mapper.javaClass}]", e)
                }
            }
        }
    }

}
