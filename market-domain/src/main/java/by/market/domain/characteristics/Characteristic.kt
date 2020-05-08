package by.market.domain.characteristics

import by.market.domain.BaseEntity
import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.DataType
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*


@Entity
@Table(name = "TBX_CH_CHARACTERISTIC")
class Characteristic : BaseEntity() {

    @Column(name = "TITLE")
    var title: String? = null

    @ManyToOne
    @JoinColumn(name = "FK_DATA_TYPE")
    var dataType: DataType? = null


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "characteristic")
    @JsonBackReference("characteristic_characteristic_doubles")
    val characteristicDoubles: Set<DoubleCharacteristic> = HashSet();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "characteristic")
    @JsonBackReference("characteristic_characteristic_strings")
    val characteristicStrings: Set<StringCharacteristic> = HashSet();

}
