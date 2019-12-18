@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document

class EmptyProductListener<TItem> : IProductListener<TItem> {
  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
  }

  override fun onLoadPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
  }

  override fun onLoadItem(doc: Document, item: TItem, pageNumber: UInt) {
  }
}
