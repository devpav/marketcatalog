@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document

class PrintProductListener<TItem>() : IProductListener<TItem> {
  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
    println("On load document: ${pageNumber}, Title: ${doc.title()}")
  }

  override fun onLoadItem(doc: Document, item: TItem, pageNumber: UInt) {
  }

  override fun onLoadDetailPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
  }

  override fun afterFillDetails(doc: Document, product: TItem) {
    println("********************************** On afterFillDetails[${doc.title()}] **********************************")
  }

  override fun onEndError(e: Exception) {
    println("========================================================================== On END ERROR $e ${e.stackTrace} ==========================================================================")
  }
}
