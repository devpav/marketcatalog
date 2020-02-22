package by.market.core.parser.asforos_product_source

import abstraction.IParserContext
import by.market.core.IAsforosProductSource
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import javassist.NotFoundException
import product.AsforosProduct
import java.io.File
import java.io.FileNotFoundException

class FilesystemAsforosProductSource(dirPath: String) : IAsforosProductSource {

    private var dirMap: Map<String, File>
    private val serializer = ObjectMapper()

    init {
        val dirFile = File(dirPath)
        if(!dirFile.exists())
            throw FileNotFoundException("Not found dir")

        val dirMutMap = mutableMapOf<String, File>()
        dirFile.walk().filter { it.isDirectory }.forEach {
            dirMutMap[it.name] = it
        }

        dirMap = dirMutMap
    }

    override fun get(ctx: IParserContext): List<AsforosProduct> {
        val dir = dirMap[ctx.productName]
        if(dir != null){
            return dir.walk().filter { it.isFile }.map {
                return@map serializer.readValue<List<AsforosProduct>>(it)
            }
            .flatten()
            .toList()
        }
        else{
            throw NotFoundException("Not found dir with name: ${ctx.productName}")
        }
    }
}
