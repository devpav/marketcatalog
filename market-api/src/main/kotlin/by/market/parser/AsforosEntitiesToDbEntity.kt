package by.market.parser

import abstraction.IParserContext
import by.market.core.IAsforosProductSource
import by.market.core.IMapper
import by.market.domain.AbstractProduct
import by.market.parser.asforos_product_source.ParserAsforosProductSource
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import product.AsforosProduct

open class AsforosEntitiesToDbEntity<TProduct: AbstractProduct>(private val context: IParserContext,
                                                                private val mapper: IMapper<AsforosProduct, TProduct>) {

    private var backProductSource: IAsforosProductSource? = null

    var productSource: IAsforosProductSource
        get() {
            val curProductSource = backProductSource
            if(curProductSource != null)
                return curProductSource

            synchronized(context){
                var curProductSource = backProductSource
                if(curProductSource != null)
                    return curProductSource

                curProductSource = ParserAsforosProductSource(LogListener(logger))
                backProductSource = curProductSource
                return curProductSource
            }
        }

    set(value) {
        synchronized(context){
            backProductSource = value
        }
    }

    private val logger = LoggerFactory.getLogger(javaClass)

    fun process() {
        var parseProducts: List<AsforosProduct>?
        try {
            parseProducts = productSource.get(context)

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
