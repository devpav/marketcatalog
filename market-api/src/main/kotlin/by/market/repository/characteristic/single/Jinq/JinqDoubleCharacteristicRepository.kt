package by.market.repository.characteristic.single.Jinq

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.repository.BaseJinqRepositoryImpl
import org.springframework.stereotype.Repository

@Repository
class JinqDoubleCharacteristicRepository : BaseJinqRepositoryImpl<DoubleCharacteristic>() {
    override fun entityType(): Class<DoubleCharacteristic> = DoubleCharacteristic::class.java
}
