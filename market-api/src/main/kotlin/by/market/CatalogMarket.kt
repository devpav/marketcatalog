package by.market

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class CatalogMarket

fun main(args: Array<String>) {
    SpringApplication.run(CatalogMarket::class.java, *args)
}

