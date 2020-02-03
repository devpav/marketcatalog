package by.market.repository.characteristic.single.Jinq

import by.market.domain.characteristics.single.StringCharacteristic
import by.market.repository.BaseJinqRepositoryImpl
import org.springframework.stereotype.Component

@Component
class JinqStringCharacteristicRepository : BaseJinqRepositoryImpl<StringCharacteristic>() {
    override fun entityType(): Class<StringCharacteristic> = StringCharacteristic::class.java
}
