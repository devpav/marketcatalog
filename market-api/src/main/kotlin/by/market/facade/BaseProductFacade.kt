package by.market.facade

import by.market.domain.AbstractProduct
import by.market.domain.system.Category
import by.market.mapper.IMapstructMapper
import by.market.mapper.dto.AbstractFrontEndProduct
import by.market.mapper.dto.system.CategoryFrontEnd
import by.market.services.abstraction.IProductService

open class BaseProductFacade<TDto : AbstractFrontEndProduct, TEntity : AbstractProduct>(entityService: IProductService<TEntity>,
                                                                                        mapper: IMapstructMapper<TDto, TEntity>,
                                                                                        protected val categoryMapper: IMapstructMapper<CategoryFrontEnd, Category>)
    : IProductFacade<TDto>, AbstractFacade<IProductService<TEntity>, TDto, TEntity>(entityService, mapper) {
    override fun findByCategory(category: CategoryFrontEnd): MutableList<TDto> {
        var databaseCategory = categoryMapper.from(category)
        val entitiesByCategory = entityService.findByCategory(databaseCategory)
        return mapper.to(entitiesByCategory).toMutableList()
    }
}
