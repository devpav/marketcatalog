@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import abstraction.IProductListener
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.jsoup.nodes.Document
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Paths

class SaveProductListener<TItem>(private val dir: String, private val savePath: String, private val charset: Charset = Charset.forName("UTF-8")) : IProductListener<TItem> {
  private val serializer = ObjectMapper()

  init {
    val dir = File(dir)
    if(!dir.exists())
      dir.mkdirs()

    serializer.enable(SerializationFeature.INDENT_OUTPUT)
  }

  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
  }

  override fun onLoadPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
    val path = Paths.get(dir, pageNumber.toString() + savePath)
    val file = path.toFile()
    file.createNewFile()

    val writer = file.writer(charset)
    serializer.writeValue(writer, items)
  }
}
