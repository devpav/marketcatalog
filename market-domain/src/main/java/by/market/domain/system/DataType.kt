package by.market.domain.system

import by.market.domain.BaseEntity
import by.market.domain.characteristics.Characteristic
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity()
@Table(name = "TBX_S_DATA_TYPE")
class DataType : BaseEntity() {

    @Column(name = "NAME")
    var name: String? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dataType")
    @JsonBackReference("data_type_characteristics")
    var characteristics: Set<Characteristic> = HashSet()

}
