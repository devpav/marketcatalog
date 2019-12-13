package by.market.services.implementation.system

import by.market.domain.system.Category
import by.market.repository.system.CategoryRepository
import by.market.services.implementation.BaseService
import org.springframework.stereotype.Service

@Service
class CategoryService(repository: CategoryRepository)
    : BaseService<Category, CategoryRepository>(repository)
