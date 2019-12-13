@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document

class PrintProductListener(private val listener: IProductListener) : IProductListener {
  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
    println("On load document: ${pageNumber}, Title: ${doc.title()}")
    listener.onLoadDocument(doc, pageNumber)
  }

  override fun <TItem> onLoadPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
    println("********************************** On Load Page[${pageNumber}] **********************************")
    listener.onLoadPageItems(doc, items, pageNumber)
  }
}
