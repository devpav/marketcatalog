package by.market.facade.impl

import by.market.domain.characteristics.AbstractCharacteristic
import by.market.dto.characteristics.AbstractCharacteristicDTO
import by.market.mapper.CharacteristicValueMapper
import by.market.services.impl.ProductValueService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductCharacteristicValueFacade(private val productValueService: ProductValueService) {

    @Autowired
    private lateinit var characteristicValueMapper: CharacteristicValueMapper

    public fun save(entity: AbstractCharacteristicDTO<Any>): AbstractCharacteristic<Any>? {
        val abstractCharacteristic = characteristicValueMapper.fromMap(entity)
        return productValueService.save(abstractCharacteristic)
    }

}