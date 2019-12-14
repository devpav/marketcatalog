@file:Suppress("UNUSED_VARIABLE", "EXPERIMENTAL_UNSIGNED_LITERALS")

import arrow.core.Option
import com.fasterxml.jackson.databind.ObjectMapper
import enums.AsforosProductContext
import parser.AsforosProductParser
import parser.parse
import product.AsforosProduct
import product_listener.PrintProductListener
import product_listener.SaveProductListener
import utility.profileTimeScope
import java.io.File

fun main() {
  val allContext = AsforosProductContext.values()

  printInfoAboutInput(allContext)

  val input = readLine() ?: ""

  val parseIndexes = input
    .split(" ", ",")
    .map { it.trim().toIntOrNull() }
    .filter { it != null && it in allContext.indices }
    .map { allContext[it!!] }
    .toMutableList()

  profileTimeScope("Parse All"){
    try {
      if(parseIndexes.count() == 0){
        parseIndexes.addAll(allContext)
      }

      println("Parse: ${parseIndexes.count()} elements")

      parseIndexes.forEach { context ->
        profileTimeScope("Parse: ${context.productName}"){
          val ignoreResult = parse(context)
        }
      }

      println("End parse: ${parseIndexes.count()} elements")
    }
    catch (ex: Exception){
      println("Error: $ex")
    }
  }

  println("Done...")
}

fun parse(context: AsforosProductContext): List<AsforosProduct> {
  val saveListener = SaveProductListener<AsforosProduct>("json/${context.productName}", "${context.productName}.json")
  val printListener = PrintProductListener(saveListener)

  val parser = AsforosProductParser(Option.just(2500u))
  return parser.parse(context, printListener)
}

fun printInfoAboutInput(items: Array<AsforosProductContext>) {
  val newLine = System.lineSeparator()
  val contextStr = items
    .withIndex()
    .joinToString(newLine) { it.index.toString() + " - " + it.value.productName.capitalize() }

  println("Empty, if need load all or")
  println(contextStr)
  print("Input: ")
}

fun getAllProperties(): Set<String> {
  val set = HashSet<String>()
  val parser = ObjectMapper()
  val directories = File("json").walk().filter { it.isFile }.toList()
  directories.forEach { json ->
    parser.readValue(json.readText(), Array<AsforosProduct>::class.java).forEach { product ->
      product.properties.forEach{ prop ->
        set.add(prop.key)
      }

      product.propertiesFromDetailPage.forEach{ prop ->
        set.add(prop.key)
      }
    }
  }
  return set
}
