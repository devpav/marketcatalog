package by.market.domain.system

import by.market.domain.BaseEntity
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity(name = "TBX_S_ENTITY_METADATA")
class EntityMetadata : BaseEntity() {

    @Column(name = "TABLE_NAME")
    var tableName: String? = null

    @Column(name = "DESCRIPTION")
    var description: String? = null

    @ManyToOne
    @JoinColumn(name = "FK_CONTAINER")
    var container: ContainerMetadata? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entityMetadata")
    @JsonBackReference("entity_metadata_characteristic_doubles")
    val characteristicDoubles: Set<DoubleCharacteristic> = HashSet();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entityMetadata")
    @JsonBackReference("entity_metadata_characteristic_strings")
    val characteristicStrings: Set<StringCharacteristic> = HashSet();

}
