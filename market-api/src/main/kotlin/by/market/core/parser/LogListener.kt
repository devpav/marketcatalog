package by.market.core.parser

import org.jsoup.nodes.Document
import org.slf4j.Logger
import parser.AsforosProduct
import parser.IProductListener

class LogListener(logger: Logger) : IProductListener<AsforosProduct> {

    private val log = logger

    override fun onEndError(e: Exception) {
        log.error("On End Error", e)
    }

    override fun onLoadDetailPageItems(doc: Document, items: List<AsforosProduct>, pageNumber: UInt) {
    }

    override fun afterFillDetails(doc: Document, product: AsforosProduct) {
    }

    override fun onLoadDocument(doc: Document, pageNumber: UInt) {
        log.info("On load Document[page - {}]: {}", pageNumber, doc.title())
    }

    override fun onLoadItem(doc: Document, item: AsforosProduct, pageNumber: UInt) {
    }

}
