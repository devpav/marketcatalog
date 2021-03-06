@file:Suppress("EXPERIMENTAL_API_USAGE")

package product_listener

import org.jsoup.nodes.Document
import parser.IProductListener

open class EmptyProductListener<TItem> : IProductListener<TItem> {
  override fun onLoadDocument(doc: Document, pageNumber: UInt) {
  }

  override fun onLoadItem(doc: Document, item: TItem, pageNumber: UInt) {
  }

  override fun onLoadDetailPageItems(doc: Document, items: List<TItem>, pageNumber: UInt) {
  }

  override fun afterFillDetails(doc: Document, product: TItem) {
  }

  override fun onEndError(e: Exception) {
  }
}
