@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.jsoup.nodes.Document
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Paths

class SaveProductListener<TItem>(private val dirPath: String,
                                 private val additionalSirTemplate: String = "%s.json",
                                 private val charset: Charset = Charset.forName("UTF-8"))
  : EmptyProductListener<TItem>()
{
  private val serializer = ObjectMapper()

  init {
    val dirObj = File(dirPath)
    if(!dirObj.exists())
      dirObj.mkdirs()

    serializer.enable(SerializationFeature.INDENT_OUTPUT)
  }

  override fun onLoadDetailPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
    val file = makeFile(dirPath, pageNumber.toString())
    val writer = file.writer(charset)
    serializer.writeValue(writer, items)
  }

  private fun makeFile(dir: String, additionalPathStr: String) : File {
    val tailStr = String.format(additionalSirTemplate, additionalPathStr)
    val path = Paths.get(dir, tailStr)
    val file = path.toFile()
    file.createNewFile()
    return file
  }
}
