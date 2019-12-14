package by.market.domain.characteristics

import javax.persistence.MappedSuperclass

@MappedSuperclass
open class AbstractSingleCharacteristic<TValue> : AbstractCharacteristic<TValue>()
