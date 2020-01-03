package product_listener

import abstraction.IProductListener
import org.jsoup.nodes.Document

class ChainProductListenerBuilder<T>{

    private val store: MutableList<IProductListener<T>> = mutableListOf()

    fun add(listener: IProductListener<T>): ChainProductListenerBuilder<T> {
        store.add(listener)
        return this
    }

    fun build(): IProductListener<T> {
        return ChainProductListener(store)
    }

    class ChainProductListener<T>(private val store: List<IProductListener<T>>) : IProductListener<T> {
        override fun onEndError(e: Exception) {
            store.forEach {
                it.onEndError(e)
            }
        }

        override fun afterFillDetails(doc: Document, product: T) {
            store.forEach {
                it.afterFillDetails(doc, product)
            }
        }

        override fun onLoadDetailPageItems(doc: Document, items: List<T>, pageNumber: UInt) {
            store.forEach {
                it.onLoadDetailPageItems(doc, items, pageNumber)
            }
        }

        override fun onLoadDocument(doc: Document, pageNumber: UInt) {
            store.forEach {
                it.onLoadDocument(doc, pageNumber)
            }
        }

        override fun onLoadItem(doc: Document, item: T, pageNumber: UInt) {
            store.forEach {
                it.onLoadItem(doc, item, pageNumber)
            }
        }
    }
}
