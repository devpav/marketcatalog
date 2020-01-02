@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document

class ErrorHandlerListener<TItem>(private val listener: IProductListener<TItem>) : IProductListener<TItem> {
  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
    try {
      listener.onLoadDocument(doc, pageNumber)
    } catch (e: Exception){
      println("Error 'onLoadDocument' - $e")
    }
  }

  override fun onLoadItem(doc: Document, item: TItem, pageNumber: UInt) {
    try {
      listener.onLoadItem(doc, item, pageNumber)
    } catch (e: Exception){
      println("Error 'onLoadItem' - $e")
    }
  }

  override fun onLoadDetailPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
    try {
      listener.onLoadDetailPageItems(doc, items, pageNumber)
    } catch (e: Exception){
      println("Error 'onLoadWithoutDetailPageItems' - $e")
    }
  }

  override fun afterFillDetails(doc: Document, product: TItem) {
    try {
      listener.afterFillDetails(doc, product)
    } catch (e: Exception){
      println("Error 'afterFillDetails' - $e")
    }
  }

  override fun onEndError(e: java.lang.Exception) {
    try {
        listener.onEndError(e)
    }catch (e: Exception) {
      println("Error 'onEndError' - $e")
    }
  }
}
