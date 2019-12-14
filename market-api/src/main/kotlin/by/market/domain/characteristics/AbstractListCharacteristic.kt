package by.market.domain.characteristics

import javax.persistence.MappedSuperclass

@MappedSuperclass
open class AbstractListCharacteristic<TValue> : AbstractCharacteristic<TValue>()
