package by.market.core.facade.characteristics

import by.market.core.facade.AbstractFacade
import by.market.domain.characteristics.ProductCharacteristic
import by.market.dto.characteristics.ProductCharacteristicDTO
import by.market.mapper.domain_dto_mapper.characteristics.ProductCharacteristicMapper
import by.market.services.abstraction.ICharacteristicService
import by.market.services.characteristic.ProductCharacteristicService
import org.springframework.stereotype.Component

@Component
class ProductCharacteristicFacade(
        productCharacteristicService: ProductCharacteristicService,
        productCharacteristicMapper: ProductCharacteristicMapper
) : AbstractFacade<ICharacteristicService<ProductCharacteristic>, ProductCharacteristicDTO, ProductCharacteristic>(
        productCharacteristicService,
        productCharacteristicMapper)
