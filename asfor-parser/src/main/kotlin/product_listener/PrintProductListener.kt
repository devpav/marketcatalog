@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document

class PrintProductListener<TItem>(private val listener: IProductListener<TItem>) : IProductListener<TItem> {
  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
    println("On load document: ${pageNumber}, Title: ${doc.title()}")
    listener.onLoadDocument(doc, pageNumber)
  }

  override fun onLoadPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
    println("********************************** On Load Page[${pageNumber}] **********************************")
    listener.onLoadPageItems(doc, items, pageNumber)
  }
}
