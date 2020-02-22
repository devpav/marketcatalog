package by.market.core.parser

class AsforosProduct(
  var imgUrl: String = "",
  var title: String = "",
  var price: String = "",
  var moreDetailsUrl: String = "",
  var category: String = "",
  var properties: MutableMap<String, String> = mutableMapOf(),
  var propertiesFromDetailPage: MutableMap<String, List<String>> = mutableMapOf()
) {

  override fun toString(): String
   = "ImgUrl: $imgUrl, Title: $title, Price: $price, MoreDetailsUrl: $moreDetailsUrl, Category: $category"
}
