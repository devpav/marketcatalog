package by.market.domain.characteristics

import javax.persistence.MappedSuperclass

@MappedSuperclass
class AbstractSingleCharacteristic<TValue> : AbstractCharacteristic<TValue>()
