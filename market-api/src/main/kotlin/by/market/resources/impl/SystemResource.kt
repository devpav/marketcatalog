package by.market.resources.impl

import by.market.dto.system.CategoryDTO
import by.market.dto.system.ContainerMetadataDTO
import by.market.dto.system.ContentPage
import by.market.dto.system.DataTypeDTO
import by.market.facade.impl.CategoryProductFacade
import by.market.facade.impl.ContainerMetadataFacade
import by.market.facade.impl.DataTypeFacade
import by.market.facade.impl.EntityMetadataFacade
import by.market.mapper.dto.system.EntityMetadataDTO
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

