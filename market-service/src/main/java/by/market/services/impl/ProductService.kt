@file:Suppress("ConvertSecondaryConstructorToPrimary")

package by.market.services.impl

import by.market.core.Constant
import by.market.domain.product.ProductAccessory
import by.market.domain.product.ProductCornice
import by.market.domain.product.ProductJalousie
import by.market.domain.product.ProductRolstor
import by.market.repository.product.ProductAccessoryRepository
import by.market.repository.product.ProductCorniceRepository
import by.market.repository.product.ProductJalousieRepository
import by.market.repository.product.ProductRolstorRepository
import org.springframework.stereotype.Service

@Service
class ProductAccessoryService : BaseProductService<ProductAccessory, ProductAccessoryRepository> {

    constructor(repository: ProductAccessoryRepository) : super(repository, Constant.EntityMetadata.Accessory)

}

@Service
class ProductCorniceService : BaseProductService<ProductCornice, ProductCorniceRepository> {

    constructor(repository: ProductCorniceRepository) : super(repository, Constant.EntityMetadata.Cornice)

}

@Service
class ProductJalousieService : BaseProductService<ProductJalousie, ProductJalousieRepository> {

    constructor(repository: ProductJalousieRepository) : super(repository, Constant.EntityMetadata.Jalousie)

}

@Service
class ProductRolstorService : BaseProductService<ProductRolstor, ProductRolstorRepository> {

    constructor(repository: ProductRolstorRepository) : super(repository, Constant.EntityMetadata.Rolstor)

}
