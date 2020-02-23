package by.market.facade.impl

import by.market.domain.product.ProductAccessory
import by.market.domain.product.ProductCornice
import by.market.domain.product.ProductJalousie
import by.market.domain.product.ProductRolstor
import by.market.dto.product.ProductAccessoryDTO
import by.market.dto.product.ProductCorniceDTO
import by.market.dto.product.ProductJalousieDTO
import by.market.dto.product.ProductRolstorDTO
import by.market.mapper.domain_dto_mapper.product.ProductAccessoryMapper
import by.market.mapper.domain_dto_mapper.product.ProductCorniceMapper
import by.market.mapper.domain_dto_mapper.product.ProductJalosieMapper
import by.market.mapper.domain_dto_mapper.product.ProductRolstorMapper
import by.market.services.impl.ProductAccessoryService
import by.market.services.impl.ProductCorniceService
import by.market.services.impl.ProductJalousieService
import by.market.services.impl.ProductRolstorService
import org.springframework.stereotype.Component

@Component
class ProductAccessoryFacade (productAccessoryService: ProductAccessoryService, productAccessoryMapper: ProductAccessoryMapper)
    : BaseProductFacade<ProductAccessoryDTO, ProductAccessory>(productAccessoryService, productAccessoryMapper)


@Component
class ProductCorniceFacade(productCorniceService: ProductCorniceService, productCorniceMapper: ProductCorniceMapper)
    : BaseProductFacade<ProductCorniceDTO, ProductCornice>(productCorniceService, productCorniceMapper)

@Component
class ProductJalousieFacade(productJalousieService: ProductJalousieService, productJalousieMapper: ProductJalosieMapper)
    : BaseProductFacade<ProductJalousieDTO, ProductJalousie>(productJalousieService, productJalousieMapper)

@Component
class ProductRolstorFacade(productRolstorService: ProductRolstorService, productRolstorMapper: ProductRolstorMapper)
    : BaseProductFacade<ProductRolstorDTO, ProductRolstor>(productRolstorService, productRolstorMapper)
