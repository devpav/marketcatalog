package product

class AsforosProduct(
  var imgUrl: String,
  var title: String,
  var price: String,
  var moreDetailsUrl: String,
  var properties: MutableMap<String, String>,
  var propertiesFromDetailPage: MutableMap<String, List<String>>
) {

  override fun toString(): String
   = "ImgUrl: ${imgUrl}, Title: ${title}, Price: ${price}, MoreDetailsUrl: ${moreDetailsUrl}"
}
