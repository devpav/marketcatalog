@file:Suppress("EXPERIMENTAL_API_USAGE", "EXPERIMENTAL_UNSIGNED_LITERALS")

package parser

import abstraction.IParserContext
import abstraction.IProductListener
import abstraction.IProductParser
import arrow.core.Option
import arrow.core.getOrElse
import dal.ProductCategory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import product.AsforosProduct
import kotlin.concurrent.getOrSet

class AsforosProductParser(storeCapacity: Option<UInt> = Option.empty()) : IProductParser<AsforosProduct> {
  private val capacity: UInt = storeCapacity.getOrElse { 0u }
  private val nodeStore: ThreadLocal<MutableList<Pair<HtmlEl, Element>>> = ThreadLocal()
  private val builderStore: ThreadLocal<StringBuilder> = ThreadLocal()

  override fun parseAsync(context: IParserContext, listener: IProductListener<AsforosProduct>) = GlobalScope.async {
    context.categories.map { category ->
      val pageUri = category.uri
      fun buildPageUri(pageNumber: UInt) =  pageUri + PageIdStr + pageNumber.toString()

      val doc = openDocByUri(pageUri)

      listener.onLoadDocument(doc, 1u)

      val firstPageTaskItems = loadAsyncByCategories(doc, listener, 1u, category)

      val pageCount = getPageNumber(doc)

      if (pageCount <= 1)
        return@async firstPageTaskItems

      val loadItems = (2u..pageCount.toUInt())
              .map { pageId ->
                async {
                  val curPageUri = buildPageUri(pageId)
                  val curPageDoc = openDocByUri(curPageUri)

                  listener.onLoadDocument(curPageDoc, pageId)

                  loadAsyncByCategories(curPageDoc, listener, pageId, category)
                }
              }
              .toList()

      val allItems = ArrayList<AsforosProduct>(capacity.or(0u).toInt())
      allItems.addAll(firstPageTaskItems)

      val res = mutableListOf<AsforosProduct>()
      res.addAll(allItems)
      res.addAll(loadItems.flatMap { it.await() })
      res
    }
      .flatten()
      .toList()
  }

  private fun openDocByUri(uri: String): Document
  {
    val connection = Jsoup.connect(uri)
    return connection.get()
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

  private fun extract(doc: Document, listener: IProductListener<AsforosProduct>, pageNumber: UInt, category: ProductCategory): List<AsforosProduct>
  {
    val productPreviewItems = doc.select("div.product-preview")
    val result = ArrayList<AsforosProduct>(productPreviewItems.count())
    productPreviewItems.forEach { s ->
      val product = createDefaultProduct()
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

      if (product.moreDetailsUrl.isEmpty())
      {
        result.add(product)
        return@forEach
      }

      fillFromDetailPage(product, listener, pageNumber)
      result.add(product)
    }

    return result
  }

  private fun fillFromDetailPage(product: AsforosProduct, listener: IProductListener<AsforosProduct>, pageNumber: UInt) {
    val detailDoc = openDocByUri(product.moreDetailsUrl)
    listener.onLoadDocument(detailDoc, pageNumber)

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
                val srcValue = builderStore.getOrSet { java.lang.StringBuilder(128) }
                  .clear()
                  .append("src='").append(Site).append(attributes["src"]).append("' alt='")
                  .append(attributes["alt"]).append('\'')
                  .toString()

                detailItems.add(srcValue)
              }
              else {
                val divProductItemText = divItemScuItemText.selectFirst("div")
                if (divProductItemText != null) {
                  val txt = divProductItemText.text()

                  if(!txt.isEmpty())
                    detailItems.add(txt)
                }
              }
            }
          product.propertiesFromDetailPage[propName] = detailItems
        }
        else -> throw Throwable("Not support type ${detailItem.first}")
      }
    }
  }

  private fun loadAsyncByCategories(doc: Document, listener: IProductListener<AsforosProduct>, pageNumber: UInt, category: ProductCategory): List<AsforosProduct> {
    val firstPageItems = extract(doc, listener, pageNumber, category)
    listener.onLoadPageItems(doc, firstPageItems, pageNumber)
    return firstPageItems
  }

  private fun createDefaultProduct() = AsforosProduct("", "", "", "", "", mutableMapOf(), mutableMapOf())

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
