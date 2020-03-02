package by.market.core.parser.mapper

import by.market.core.IMapper
import by.market.domain.AbstractProduct
import by.market.domain.system.Category
import by.market.repository.AbstractProductRepository
import by.market.repository.system.CategoryRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import parser.AsforosProduct
import javax.annotation.PostConstruct

abstract class BaseParserMapper<TProduct: AbstractProduct>(
        protected val rep: AbstractProductRepository<TProduct>
) : IMapper<AsforosProduct, TProduct> {
    private lateinit var categoryMap: HashMap<String, Category?>

    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var characteristicMapperHandler: CharacteristicMapperHandler
    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @PostConstruct
    private fun init() {
        try {
            categoryMap = createCategoryMap()
        }catch (e: Exception){
            logger.error("Error when CreateCategoryMap", e)
            throw e;
        }
    }

    @Transactional
    override suspend fun map(value: AsforosProduct): TProduct {
        val productPair = getDatabaseProductOrMakeEmptyProduct(value.title)
        val product = productPair.first
        product.img = value.imgUrl
        product.title = value.title
        product.category = categoryMap[value.category]
        if(product.category == null)
            logger.warn("Not found category: {}", value.category)

        product.id = rep.saveAndFlush(product).id

        try {
            characteristicMapperHandler.handle(productPair.second, product, value)
        }catch (e: Exception){
            logger.error("Error [characteristicMapperHandler.handle] IsNew[${productPair.second}]", e)
        }

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
        val map = HashMap<String, Category?>()

        val it = categoryRepository.findAll()
        it.filterNotNull().forEach {
            if(it.systemName != null)
                map[it.systemName!!] = it
        }

        return map
    }
}
