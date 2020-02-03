package by.market.domain.characteristics

import by.market.domain.BaseEntity
import by.market.domain.system.EntityMetadata
import java.util.*
import javax.persistence.Column
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractCharacteristic<T> : BaseEntity() {

    @Column(name = "value")
    var value: T? = null
        public get
        public set

    @ManyToOne
    @JoinColumn(name = "id_product_characteristic")
    var productCharacteristic: ProductCharacteristic? = null
        public get
        public set

    @ManyToOne
    @JoinColumn(name = "id_entity_metadata")
    var entityMetadata: EntityMetadata? = null
        public get
        public set

    @Column(name = "id_product_row")
    var productRowId: UUID? = null
        public get
        public set
}
