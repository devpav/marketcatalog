@file:Suppress("EXPERIMENTAL_API_USAGE")

package by.market.core.parser

import org.jsoup.nodes.Document

interface IProductListener<TItem> {
  fun onEndError(e: Exception)
  fun onLoadDetailPageItems(doc: Document, items: List<TItem>, pageNumber: UInt)
  fun afterFillDetails(doc: Document, product: TItem)

  fun onLoadDocument(doc: Document, pageNumber: UInt)
  fun onLoadItem(doc: Document, item: TItem, pageNumber: UInt)
}
