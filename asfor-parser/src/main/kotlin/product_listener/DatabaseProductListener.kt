package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document
import product.AsforosProduct

class DatabaseProductListener : IProductListener<AsforosProduct> {
    override fun onLoadDocument(doc: Document, pageNumber: UInt) {
    }

    override fun onLoadItem(doc: Document, item: AsforosProduct, pageNumber: UInt) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadPageItems(doc: Document, items: List<AsforosProduct>, pageNumber: UInt) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
