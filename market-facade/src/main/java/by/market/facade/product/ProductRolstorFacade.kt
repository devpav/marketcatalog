package by.market.core.facade.product

import by.market.core.facade.BaseProductFacade
import by.market.domain.product.ProductRolstor
import by.market.domain.system.Category
import by.market.dto.product.ProductRolstorDTO
import by.market.dto.product.ProductRolstorService
import by.market.dto.system.CategoryDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.domain_dto_mapper.product.ProductRolstorMapper
import org.springframework.stereotype.Component

@Component
class ProductRolstorFacade(
        productRolstorService: ProductRolstorService,
        productRolstorMapper: ProductRolstorMapper,
        categoryMapper: IMapstructMapper<CategoryDTO, Category>
) : BaseProductFacade<ProductRolstorDTO, ProductRolstor>(productRolstorService,
        productRolstorMapper,
        categoryMapper)
