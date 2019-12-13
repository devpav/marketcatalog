package abstraction

import dal.ProductCategory

interface IParserContext {
  val productName: String
  val pageUri: String
  val categories: Array<ProductCategory>
}
