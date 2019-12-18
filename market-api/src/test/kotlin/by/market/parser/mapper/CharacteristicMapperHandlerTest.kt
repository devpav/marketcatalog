package by.market.parser.mapper

import by.market.repository.characteristic.ProductCharacteristicRepository
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import product.AsforosProduct
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@SpringBootTest
@RunWith(SpringRunner::class)
class CharacteristicMapperHandlerTest {

    @Autowired
    private lateinit var productCorniceMapper: ProductCorniceMapper
    @Autowired
    private lateinit var productCharacteristicRepository: ProductCharacteristicRepository

    @Test
    @DisplayName("Проверка на загрузку данных с asforos")
    fun handle() {
        val asforosProduct = AsforosProduct()
        asforosProduct.title = "title product"
        asforosProduct.category = "metallic"
        asforosProduct.imgUrl = "https://asforos.by/upload/iblock/0ed/0ed08717b3ebcbcc8341ef35f877c1cd.JPG"
        asforosProduct.properties = mutableMapOf(
                Pair("Цвет", "Желтый"),
                Pair("Диаметр (мм)", "2.3")
        )

        val map = runBlocking { productCorniceMapper.map(asforosProduct) }

        assertNotNull(map.id)
        assertNotNull(map.title)

        assertEquals(map.title, asforosProduct.title)
        assertEquals(map.img, asforosProduct.imgUrl)

        val characteristics = productCharacteristicRepository.findAll()

        assertEquals(characteristics.size, 2);

        assertTrue(characteristics.any { it.title.equals("Цвет") })
        assertTrue(characteristics.any { it.title.equals("Диаметр (мм)") })
    }

}