@file:Suppress("EXPERIMENTAL_API_USAGE")

package abstraction

import org.jsoup.nodes.Document

interface IProductListener {
  fun onLoadDocument(doc: Document, pageNumber: UInt)
  fun <TItem>onLoadPageItems(doc: Document, items: List<TItem>, pageNumber: UInt)
}
