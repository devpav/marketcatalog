@file:Suppress("EXPERIMENTAL_API_USAGE")

package abstraction

import org.jsoup.nodes.Document

interface IProductListener<TItem> {
  fun onLoadDocument(doc: Document, pageNumber: UInt)
  fun onLoadItem(doc: Document, item: TItem, pageNumber: UInt)
  fun onLoadPageItems(doc: Document, items: List<TItem>, pageNumber: UInt)
}
