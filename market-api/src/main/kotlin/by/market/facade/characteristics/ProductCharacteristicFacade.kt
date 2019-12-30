package by.market.facade.characteristics

import by.market.domain.characteristics.ProductCharacteristic
import by.market.facade.AbstractFacade
import by.market.mapper.domain_dto_mapper.characteristics.ProductCharacteristicMapper
import by.market.mapper.dto.characteristics.ProductCharacteristicFrontEnd
import by.market.services.implementation.characteristic.ProductCharacteristicService
import org.springframework.stereotype.Component

@Component
class ProductCharacteristicFacade(
        private val productCharacteristicService: ProductCharacteristicService,
        private val productCharacteristicMapper: ProductCharacteristicMapper
) : AbstractFacade<ProductCharacteristicFrontEnd, ProductCharacteristic>(productCharacteristicService, productCharacteristicMapper)