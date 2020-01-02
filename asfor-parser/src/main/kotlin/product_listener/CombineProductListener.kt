package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document

class CombineProductListener<TProduct>(private val first: IProductListener<TProduct>,
                                       private val second: IProductListener<TProduct>)
    : IProductListener<TProduct> {
    override fun onLoadDocument(doc: Document, pageNumber: UInt) {
        first.onLoadDocument(doc, pageNumber)
        second.onLoadDocument(doc, pageNumber)
    }

    override fun onLoadItem(doc: Document, item: TProduct, pageNumber: UInt) {
        first.onLoadItem(doc, item, pageNumber)
        second.onLoadItem(doc, item, pageNumber)
    }

    override fun onLoadDetailPageItems(doc: Document, items: List<TProduct>, pageNumber: UInt) {
        first.onLoadDetailPageItems(doc, items, pageNumber)
        second.onLoadDetailPageItems(doc, items, pageNumber)
    }

    override fun onEndError(e: Exception) {
        first.onEndError(e)
        second.onEndError(e)
    }

    override fun afterFillDetails(doc: Document, product: TProduct) {
        first.afterFillDetails(doc, product)
        second.afterFillDetails(doc, product)
    }
}
