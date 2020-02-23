package by.market.resources.impl

import by.market.dto.system.CategoryDTO
import by.market.dto.system.ContainerMetadataDTO
import by.market.dto.system.DataTypeDTO
import by.market.facade.impl.*
import by.market.mapper.dto.system.EntityMetadataDTO
import by.market.mapper.dto.system.ProductTypeDTO
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class CategoryResource(facade: CategoryProductFacade) : AbstractResource<CategoryDTO>(facade)

@RestController
@RequestMapping("/api/container-metadata")
class ContainerMetadataResource(facade: ContainerMetadataFacade) : AbstractResource<ContainerMetadataDTO>(facade)

@RestController
@RequestMapping("/api/data-type")
class DataTypeResource(facade: DataTypeFacade): AbstractResource<DataTypeDTO>(facade)

@RestController
@RequestMapping("/api/entity-metadata")
class EntityMetadataResource(service: EntityMetadataFacade) : AbstractResource<EntityMetadataDTO>(service)

@RestController
@RequestMapping("/api/product-type")
class ProductTypeResource(facade: ProductTypeFacade) : AbstractResource<ProductTypeDTO>(facade)
