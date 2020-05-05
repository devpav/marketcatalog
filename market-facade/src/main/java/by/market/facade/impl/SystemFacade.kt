package by.market.facade.impl

import by.market.domain.system.Category
import by.market.domain.system.ContainerMetadata
import by.market.domain.system.DataType
import by.market.domain.system.EntityMetadata
import by.market.dto.system.*
import by.market.mapper.system.CategoryMapper
import by.market.mapper.system.ContainerMetadataMapper
import by.market.mapper.system.DataTypeMapper
import by.market.mapper.system.EntityMetadataMapper
import by.market.services.impl.CategoryService
import by.market.services.impl.ContainerMetadataService
import by.market.services.impl.DataTypeService
import by.market.services.impl.EntityMetadataService
import org.springframework.stereotype.Component

@Component
class CategoryProductFacade(
        categoryService: CategoryService,
        categoryMapper: CategoryMapper
) : BaseSystemFacade<CategoryDTO, Category, CategoryService>(categoryService, categoryMapper) {

    fun findByParent(category: CategoryDTO): ContentPage<CategoryDTO> {
        val databaseCategory = mapper.from(category)!!

        val findAllByParentCategory = entityService.findAllByParentCategory(databaseCategory)
        val length = entityService.countAllByParentCategory(databaseCategory)

        val collectionDTO = mapper.to(findAllByParentCategory)!!.toMutableList()
        return ContentPage(collectionDTO, length)
    }

}


@Component
class ContainerMetadataFacade(
        containerMetadataService: ContainerMetadataService,
        containerMetadataMapper: ContainerMetadataMapper
): BaseSystemFacade<ContainerMetadataDTO, ContainerMetadata, ContainerMetadataService>(containerMetadataService, containerMetadataMapper)

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
