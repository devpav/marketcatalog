package by.market.services.impl

import by.market.domain.BaseEntity
import by.market.domain.system.*
import by.market.repository.BaseRepository
import by.market.repository.product.ProductTypeRepository
import by.market.repository.system.CategoryRepository
import by.market.repository.system.ContainerMetadataRepository
import by.market.repository.system.DataTypeRepository
import by.market.repository.system.EntityMetadataRepository
import by.market.services.abstraction.ISystemService
import org.springframework.stereotype.Service

open class BaseSystemCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : ISystemService<TEntity>, BaseService<TEntity, TRepository>(rep)


@Service
class CategoryService(repository: CategoryRepository) : BaseSystemCharacteristicService<Category, CategoryRepository>(repository){

    fun findAllByParentCategory(category: Category): List<Category> = rep.findAllByParentCategory(category)
    fun countAllByParentCategory(category: Category): Long = rep.countAllByParentCategory(category)

}

@Service
class ContainerMetadataService(repository: ContainerMetadataRepository)
    : BaseSystemCharacteristicService<ContainerMetadata, ContainerMetadataRepository>(repository)


@Service
class DataTypeService(repository: DataTypeRepository)
    : BaseSystemCharacteristicService<DataType, DataTypeRepository>(repository)

@Service
class EntityMetadataService(repository: EntityMetadataRepository)
    : BaseSystemCharacteristicService<EntityMetadata, EntityMetadataRepository>(repository)

@Service
class ProductTypeService(repository: ProductTypeRepository)
    : BaseSystemCharacteristicService<ProductType, ProductTypeRepository>(repository)
