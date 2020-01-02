@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import abstraction.IProductListener
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.jsoup.nodes.Document
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Paths

class SaveProductListener<TItem>(dir: String, private val savePath: String, private val charset: Charset = Charset.forName("UTF-8")) : IProductListener<TItem> {
  private val serializer = ObjectMapper()
  private var dirForWithoutDetails: String

  init {
    val dirObj = File(dir)
    if(!dirObj.exists())
      dirObj.mkdirs()

    dirForWithoutDetails = Paths.get(dir, "without_details").toString()

    serializer.enable(SerializationFeature.INDENT_OUTPUT)
  }

  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
  }

  override fun onLoadItem(doc: Document, item: TItem, pageNumber: UInt) {
  }

  override fun onLoadDetailPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
    val file = makeFile(dirForWithoutDetails, pageNumber)
    val writer = file.writer(charset)
    serializer.writeValue(writer, items)
  }

  private fun makeFile(dir: String, pageNumber: UInt) : File {
    return makeFile(dir, pageNumber.toString())
  }

  private fun makeFile(dir: String, additionalPathStr: String? = null) : File {
    val tailStr = if(additionalPathStr != null){
      additionalPathStr + savePath
    }else{
      savePath
    }

    val path = Paths.get(dir, tailStr)
    val file = path.toFile()
    file.createNewFile()
    return file
  }

  override fun afterFillDetails(doc: Document, product: TItem) {
    val file = makeFile(dirForWithoutDetails)
    val writer = file.writer(charset)
    serializer.writeValue(writer, product)
  }

  override fun onEndError(e: Exception) {
  }
}
