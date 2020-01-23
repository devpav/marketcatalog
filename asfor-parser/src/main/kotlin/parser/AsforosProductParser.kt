@file:Suppress("EXPERIMENTAL_API_USAGE", "EXPERIMENTAL_UNSIGNED_LITERALS")

package parser

import abstraction.IParserContext
import abstraction.IProductListener
import abstraction.IProductParser
import dal.ProductCategory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.jsoup.helper.HttpConnection
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import product.AsforosProduct
import utility.mapAsync
import utility.unwrapSync
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.getOrSet

class AsforosProductParser() : IProductParser<AsforosProduct> {
  private val nodeStore: ThreadLocal<MutableList<Pair<HtmlEl, Element>>> = ThreadLocal()
  private val connectionPool: ConcurrentLinkedQueue<HttpConnection> = ConcurrentLinkedQueue()

  override fun parse(context: IParserContext, listener: IProductListener<AsforosProduct>): List<AsforosProduct> {
    try {
      return context.categories.map { category ->
        val pageUri = category.uri
        fun buildPageUri(pageNumber: UInt) =  pageUri + PageIdStr + pageNumber.toString()

        val doc = openDocByUri(pageUri)
        listener.onLoadDocument(doc, 1u)

        val firstPageTaskItems = GlobalScope.async {
          loadAsyncByCategory(doc, listener, 1u, category)
        }

        val pageCount = getPageNumber(doc)

        if (pageCount <= 1)
          return@map firstPageTaskItems.unwrapSync()

        val loadPageItemsAfterFirstPage = (2..pageCount)
                .mapAsync { pageId ->
                  val castPageId = pageId.toUInt()

                  val curPageUri = buildPageUri(castPageId)
                  try {
                    val curPageDoc = openDocByUri(curPageUri)

                    listener.onLoadDocument(curPageDoc, castPageId)

                    loadAsyncByCategory(curPageDoc, listener, castPageId, category)
                  }catch (e: Exception){
                    null as (List<AsforosProduct>?)
                  }
                }
                .mapNotNull { it.unwrapSync() }

        loadPageItemsAfterFirstPage.flatten() + firstPageTaskItems.unwrapSync()
      }
      .flatten()
      .toList()
    }catch (e: Exception){
      listener.onEndError(e)
      return ArrayList()
    }
  }

  private fun openDocByUri(uri: String): Document
  {
    var connection = connectionPool.poll()
    if(connection == null){
      connection = HttpConnection()
      connection.timeout(10000 * 60)
    }

    connection.url(uri)
    val doc = connection.get()
    connectionPool.add(connection)
    return doc
  }

  private fun getPageNumber(doc: Document): Int
  {
    val pageItems = doc.select("div.pagination__item")

    var result = -1
    pageItems.forEach { pageItem ->
      val page = pageItem.text().toIntOrNull()
      if(page != null && page > result)
        result = page
    }

    return result
  }

  private fun extractProducts(doc: Document, category: ProductCategory, listener: IProductListener<AsforosProduct>): List<AsforosProduct>
  {
    val productPreviewItems = doc.select("div.product-preview")
    val result = ArrayList<AsforosProduct>(productPreviewItems.count())
    productPreviewItems.forEach { s ->
      val product = AsforosProduct()
      s.children().forEach { argChild ->
        when(argChild.className()){
          "product-preview__img" -> {

            val imgEl = argChild.child(0)
            val src = imgEl.attr("src")
            product.imgUrl = Site + src
          }
          "product-preview__title" -> {
            product.title = argChild.html().trim()
          }
          "product-preview__price" -> {
            product.price = argChild.children().joinToString(" ") { it.html() }
          }
          "product-preview__btn-cart btn" -> {
            val atr = argChild.attributes()
            product.moreDetailsUrl = Site + atr["href"]
          }
        }
      }

      product.category = category.name
      result.add(product)
      fillDetails(product, listener)
    }

    return result
  }

  private fun fillDetails(product: AsforosProduct, listener: IProductListener<AsforosProduct>) {
    if(product.moreDetailsUrl.isBlank())
      return

    val detailDoc = openDocByUri(product.moreDetailsUrl)

    // таблица характеристики
    var additionalInfo = detailDoc.selectFirst("div.product-quick-view__advantages__items")
    additionalInfo?.children()?.forEach { childNode ->
      val nodes = nodeStore.getOrSet { mutableListOf() }
      nodes.clear()
      nodes.addAll(childNode.children().mapNotNull { if (it.nodeName() == "p") Pair(HtmlEl.P, it) else null })

      val nameProperty = nodes[0].second.html()
      val valueProperty = nodes[1].second.html()

      product.properties[nameProperty] = valueProperty
    }

    // парсим поля с выбором характеристик
    additionalInfo = detailDoc.selectFirst("div.offers-props")
    additionalInfo?.children()?.forEach { childrenNode ->
      val detailInfo = childrenNode.children()

      val nodes = nodeStore.getOrSet { mutableListOf() }
      nodes.clear()
      nodes.addAll(detailInfo.mapNotNull {
        when (it.nodeName()) {
          "div" -> Pair(HtmlEl.Div, it)
          "span" -> Pair(HtmlEl.Span, it)
          "ul" -> Pair(HtmlEl.Ul, it)
          else -> null
        }
      })

      val propName = nodes[0].second.html()

      val detailItem = nodes[1]
      when(detailItem.first){
        HtmlEl.Span, HtmlEl.Div -> {
          val description = listOf<String>(detailItem.second.text())
          product.propertiesFromDetailPage[propName] = description
        }
        HtmlEl.Ul -> {
          val ul = detailItem.second
          val children = ul.children()
          val detailItems = ArrayList<String>(children.count())
          children
            .filter{it.nodeName().compareTo("li", true) == 0}
            .forEach {  liElement ->
              val divItemScuItemText = liElement.selectFirst("div")
              val img = divItemScuItemText.selectFirst("img")
              if (img != null) {
                val attributes = img.attributes()
                val srcValue = attributes["alt"]

                detailItems.add(srcValue)
              }
              else {
                val divProductItemText = divItemScuItemText.selectFirst("div")
                if (divProductItemText != null) {
                  val txt = divProductItemText.text()

                  if(txt.isNotEmpty() &&
                          // End list "-"
                          txt != "-")
                    detailItems.add(txt)
                }
              }
            }
          product.propertiesFromDetailPage[propName] = detailItems
        }
        else -> throw Throwable("Not support type ${detailItem.first}")
      }
    }

    listener.afterFillDetails(detailDoc, product)
  }

  private fun loadAsyncByCategory(doc: Document, listener: IProductListener<AsforosProduct>, pageNumber: UInt, category: ProductCategory): List<AsforosProduct> {
    val firstPageItems = extractProducts(doc, category, listener)
    listener.onLoadDetailPageItems(doc, firstPageItems, pageNumber)
    return firstPageItems
  }

  companion object{
    private const val Site = "https://asforos.by"
    private const val PageIdStr = "/?PAGEN_1="
  }

  private enum class HtmlEl {
    Div,
    Span,
    Ul,
    P
  }
}
