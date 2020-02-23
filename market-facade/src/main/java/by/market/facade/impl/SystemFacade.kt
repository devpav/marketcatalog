package by.market.facade.impl

import by.market.domain.system.*
import by.market.dto.system.CategoryDTO
import by.market.dto.system.ContainerMetadataDTO
import by.market.dto.system.DataTypeDTO
import by.market.mapper.domain_dto_mapper.system.CategoryMapper
import by.market.mapper.domain_dto_mapper.system.DataTypeMapper
import by.market.mapper.domain_dto_mapper.system.EntityMetadataMapper
import by.market.mapper.domain_dto_mapper.system.ProductTypeMapper
import by.market.mapper.dto.system.EntityMetadataDTO
import by.market.mapper.dto.system.ProductTypeDTO
import by.market.mapper.system.ContainerMetadataMapper
import by.market.services.impl.*
import org.springframework.stereotype.Component

@Component
class CategoryProductFacade(
        categoryService: CategoryService,
        categoryMapper: CategoryMapper
) : BaseSystemFacade<CategoryDTO, Category, CategoryService>(categoryService, categoryMapper) {
    fun findByParent(category: CategoryDTO): Collection<CategoryDTO> {
        val databaseCategory = mapper.from(category)
        return mapper.to(entityService.findAllByParentCategory(databaseCategory))
    }
}


@Component
class ContainerMetadataFacade(
        containerMetadataService: ContainerMetadataService,
        containerMetadataMapper: ContainerMetadataMapper
): BaseSystemFacade<ContainerMetadataDTO, ContainerMetadata, ContainerMetadataService>(containerMetadataService, containerMetadataMapper)


@Component
class ProductTypeFacade(
        productTypeService: ProductTypeService,
        productTypeMapper: ProductTypeMapper
) : BaseSystemFacade<ProductTypeDTO, ProductType, ProductTypeService>(productTypeService, productTypeMapper)


@Component
class EntityMetadataFacade(
        entityMetadataService: EntityMetadataService,
        entityMetadataMapper: EntityMetadataMapper
) : BaseSystemFacade<EntityMetadataDTO, EntityMetadata, EntityMetadataService>(entityMetadataService, entityMetadataMapper)


@Component
class DataTypeFacade(
        dataTypeService: DataTypeService,
        dataTypeMapper: DataTypeMapper
): BaseSystemFacade<DataTypeDTO, DataType, DataTypeService>(dataTypeService, dataTypeMapper)
