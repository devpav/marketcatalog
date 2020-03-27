package by.market.resources.impl

import by.market.dto.product.ProductAccessoryDTO
import by.market.dto.product.ProductCorniceDTO
import by.market.dto.product.ProductJalousieDTO
import by.market.dto.product.ProductRolstorDTO
import by.market.facade.impl.ProductAccessoryFacade
import by.market.facade.impl.ProductCorniceFacade
import by.market.facade.impl.ProductJalousieFacade
import by.market.facade.impl.ProductRolstorFacade
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rolstor-product")
class ProductRolstorResource(facade: ProductRolstorFacade) : BaseProductResource<ProductRolstorDTO, ProductRolstorFacade>(facade)

@RestController
@RequestMapping("/api/jalousie-product")
class ProductJalousieResource(facade: ProductJalousieFacade) : BaseProductResource<ProductJalousieDTO, ProductJalousieFacade>(facade)

@RestController
@RequestMapping("/api/cornice-product")
class ProductCorniceResource(facade: ProductCorniceFacade) : BaseProductResource<ProductCorniceDTO, ProductCorniceFacade>(facade)

@RestController
@RequestMapping("/api/accessory-product")
class ProductAccessoryResource(facade: ProductAccessoryFacade) : BaseProductResource<ProductAccessoryDTO, ProductAccessoryFacade>(facade)
