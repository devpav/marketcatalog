package by.market.facade.impl

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.dto.characteristics.AbstractCharacteristicDTO
import by.market.mapper.characteristics.single.AbstractCharacteristicValueMapper
import by.market.services.impl.ProductValueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductCharacteristicValueFacade(private val productValueService: ProductValueService) {

    @Autowired
    private lateinit var abstractCharacteristicValueMapper: AbstractCharacteristicValueMapper;

    public fun save(entity: AbstractCharacteristicDTO<Any>): AbstractCharacteristic<Any> {
        val abstractCharacteristic = abstractCharacteristicValueMapper.to(entity)
        return productValueService.save(abstractCharacteristic)
    }

}