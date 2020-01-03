package parser

import enums.AsforosProductContext
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import product_listener.SaveProductListener

internal class AsforosProductParserTest {

    @DisplayName("Parse Cornice")
    @Test
    fun parseCornice() {
        val p = AsforosProductParser()
        AsforosProductContext.values().toList().parallelStream().forEach {
            p.parse(it, SaveProductListener("E:\\json\\${it.productName}",
                    "%s${it.productName}.json"))
        }
    }
}
