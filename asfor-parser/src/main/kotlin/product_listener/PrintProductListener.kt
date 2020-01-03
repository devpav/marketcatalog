@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import org.jsoup.nodes.Document

class PrintProductListener<TItem>() : EmptyProductListener<TItem>() {
  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
    println("On load document: ${pageNumber}, Title: ${doc.title()}")
  }

  override fun afterFillDetails(doc: Document, product: TItem) {
    println("********************************** On afterFillDetails[${doc.title()}] **********************************")
  }

  override fun onEndError(e: Exception) {
    println("========================================================================== On END ERROR $e ${e.stackTrace} ==========================================================================")
  }
}
