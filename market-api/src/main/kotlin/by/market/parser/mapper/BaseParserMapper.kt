package by.market.parser.mapper

import by.market.core.IMapper
import by.market.domain.AbstractProduct
import by.market.domain.system.Category
import by.market.repository.AbstractProductRepository
import by.market.repository.system.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import product.AsforosProduct
import javax.annotation.PostConstruct

abstract class BaseParserMapper<TProduct: AbstractProduct>(
        protected val rep: AbstractProductRepository<TProduct>
) : IMapper<AsforosProduct, TProduct> {
    private lateinit var categoryMap: HashMap<String, Category?>

    @Autowired
    private lateinit var characteristicMapperHandler: CharacteristicMapperHandler
    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @PostConstruct
    private fun init() {
        categoryMap = createCategoryMap()
    }

    @Transactional
    override suspend fun map(value: AsforosProduct): TProduct {
        val productPair = getDatabaseProductOrMakeEmptyProduct(value.title)
        val product = productPair.first
        product.img = value.imgUrl
        product.title = value.title

        product.id = rep.saveAndFlush(product).id

        characteristicMapperHandler.handle(productPair.second, product, value)

        return product
    }

    private fun getDatabaseProductOrMakeEmptyProduct(title: String): Pair<TProduct, Boolean> {
        val existsByTitle = rep.existsByTitle(title)

        return if (existsByTitle) {
            Pair(rep.findByTitle(title), false)
        }else{
            Pair(getEntity(), true)
        }
    }

    abstract fun getEntity(): TProduct

    private fun createCategoryMap(): HashMap<String, Category?> {
        fun findCategory(parserCategory: String) = categoryRepository.findBySystemName(parserCategory)

        val map = HashMap<String, Category?>()
        // Карнизы
        map["metallic"] = findCategory("metallic")
        map["plastic_ceilings"] = findCategory("plastic_ceilings")
        map["wall_metal_plastic"] = findCategory("wall_metal_plastic")
        map["accessories_for_ceiling"] = findCategory("accessories_for_ceiling")
        map["accessories_for_metal"] = findCategory("accessories_for_metal")
        map["flexible"] = findCategory("flexible")
        map["metal_plastic_accessories"] = findCategory("metal_plastic_accessories")

        // Жалюзи
        map["day_night"] = findCategory("day_night")
        map["standard"] = findCategory("standard")
        map["in_box"] = findCategory("in_box")
        map["premium"] = findCategory("premium")
        map["blackout"] = findCategory("blackout")

        // Рольшторы
        map["rolstor"] = findCategory("rolstor")

        // Аксессуары
        map["luversa"] = findCategory("luversa")
        map["grips_holders_hooks"] = findCategory("grips_holders_hooks")
        map["magnetic_clips"] = findCategory("magnetic_clips")

        return map
    }
}
