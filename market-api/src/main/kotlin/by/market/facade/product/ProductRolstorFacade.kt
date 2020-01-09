package by.market.facade.product

import by.market.domain.product.ProductRolstor
import by.market.domain.system.Category
import by.market.facade.BaseProductFacade
import by.market.mapper.IMapstructMapper
import by.market.mapper.domain_dto_mapper.product.ProductRolstorMapper
import by.market.mapper.dto.product.ProductRolstorFrontEnd
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.services.implementation.product.ProductRolstorService
import org.springframework.stereotype.Component

@Component
class ProductRolstorFacade(
        productRolstorService: ProductRolstorService,
        productRolstorMapper: ProductRolstorMapper,
        categoryMapper: IMapstructMapper<CategoryFrontEnd, Category>
) : BaseProductFacade<ProductRolstorFrontEnd, ProductRolstor>(productRolstorService,
        productRolstorMapper,
        categoryMapper)
