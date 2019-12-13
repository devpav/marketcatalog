@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document

class EmptyProductListener : IProductListener{
  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
  }

  override fun <TItem> onLoadPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
  }
}
