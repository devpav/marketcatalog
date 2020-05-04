package by.market.services.impl

import by.market.domain.BaseEntity
import by.market.domain.system.Category
import by.market.domain.system.ContainerMetadata
import by.market.domain.system.DataType
import by.market.domain.system.EntityMetadata
import by.market.repository.BaseRepository
import by.market.repository.system.CategoryRepository
import by.market.repository.system.ContainerMetadataRepository
import by.market.repository.system.DataTypeRepository
import by.market.repository.system.EntityMetadataRepository
import by.market.services.ISystemService
import org.springframework.stereotype.Service
import java.util.*

open class BaseSystemCharacteristicService<TEntity: BaseEntity, TRepository: BaseRepository<TEntity>>(rep: TRepository)
    : ISystemService<TEntity>, BaseService<TEntity, TRepository>(rep)


@Service
class CategoryService(val repository: CategoryRepository) : BaseSystemCharacteristicService<Category, CategoryRepository>(repository){

    fun findAllByParentCategory(category: Category): List<Category> = rep.findAllByParentCategory(category)

    fun countAllByParentCategory(category: Category): Long = rep.countAllByParentCategory(category)

    fun findRootCategory(idCategory: UUID): Category? {
        val category = rep.findById(idCategory)

        if (category.isPresent) {
            val currentCategory = category.get()
            val parentCategory = currentCategory.parentCategory

            if (parentCategory?.id == null || currentCategory.id == parentCategory.id)
                return currentCategory

            return findRootCategory(parentCategory.id!!)
        }

        return null
    }

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

