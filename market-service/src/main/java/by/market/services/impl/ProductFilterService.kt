package by.market.services.impl

import by.market.domain.product.ProductAccessory
import by.market.domain.product.ProductCornice
import by.market.domain.product.ProductJalousie
import by.market.domain.product.ProductRolstor
import org.springframework.stereotype.Component

@Component
class ProductAccessoryFilterService : BaseProductFilterService<ProductAccessory>()

@Component
class ProductCorniceFilterService : BaseProductFilterService<ProductCornice>()

@Component
class ProductJalousieFilterService : BaseProductFilterService<ProductJalousie>()

@Component
class ProductRolstorFilterService : BaseProductFilterService<ProductRolstor>()