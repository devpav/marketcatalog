package abstraction

import dal.ProductCategory

interface IParserContext {
  val productName: String
  val categories: Array<ProductCategory>
}
