package by.market.domain.characteristics

import by.market.domain.BaseEntity
import by.market.domain.Product
import by.market.domain.system.EntityMetadata
import javax.persistence.*

@MappedSuperclass
open class AbstractCharacteristic<T> : BaseEntity() {

    @Column(name = "VALUE")
    var value: T? = null

    @ManyToOne
    @JoinColumn(name = "FK_CHARACTERISTIC")
    var characteristic: Characteristic? = null

    @ManyToOne
    @JoinColumn(name = "FK_ENTITY_METADATA")
    var entityMetadata: EntityMetadata? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PRODUCT")
    var product: Product? = null

}
