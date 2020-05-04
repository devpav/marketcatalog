package by.market.domain.system

import by.market.domain.BaseEntity
import by.market.domain.characteristics.single.DoubleCharacteristic
import javax.persistence.*

/*
* tbx_s_container (table system)
* */
@Entity(name = "TBX_S_ENTITY_METADATA")
class EntityMetadata : BaseEntity() {

    @Column(name = "TABLE_NAME")
    var tableName: String? = null
        public get
        public set

    @Column(name = "DESCRIPTION")
    var description: String? = null
        public get
        public set

    @ManyToOne
    @JoinColumn(name = "FK_CONTAINER")
    var container: ContainerMetadata? = null
        public get
        public set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entityMetadata")
    val characteristicDoubles: Set<DoubleCharacteristic> = HashSet();

}
