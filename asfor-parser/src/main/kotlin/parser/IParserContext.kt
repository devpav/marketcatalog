package parser

import dal.ProductCategory

interface IParserContext {
  val productName: String
  val categories: Array<ProductCategory>
}
