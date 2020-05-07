package by.market.resources.impl

import by.market.dto.TreeCategoryDTO
import by.market.dto.system.*
import by.market.facade.impl.CategoryProductFacade
import by.market.facade.impl.ContainerMetadataFacade
import by.market.facade.impl.DataTypeFacade
import by.market.facade.impl.EntityMetadataFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/category")
class CategoryResource(facade: CategoryProductFacade) : AbstractResource<CategoryDTO, CategoryProductFacade>(facade) {

    @GetMapping("/parent")
    fun findByParent(categoryDTO: CategoryDTO): ResponseEntity<ContentPage<CategoryDTO>>
            = ResponseEntity.ok(facade.findByParent(categoryDTO))

    @GetMapping("/tree")
    fun findTreeCategory(): ResponseEntity<MutableList<TreeCategoryDTO>> = ResponseEntity.ok(facade.findTreeCategories())

}

@RestController
@RequestMapping("/api/container-metadata")
class ContainerMetadataResource(facade: ContainerMetadataFacade) : AbstractResource<ContainerMetadataDTO, ContainerMetadataFacade>(facade)

@RestController
@RequestMapping("/api/data-type")
class DataTypeResource(facade: DataTypeFacade): AbstractResource<DataTypeDTO, DataTypeFacade>(facade)

@RestController
@RequestMapping("/api/entity-metadata")
class EntityMetadataResource(service: EntityMetadataFacade) : AbstractResource<EntityMetadataDTO, EntityMetadataFacade>(service)

