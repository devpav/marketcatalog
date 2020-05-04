package by.market.domain.system

import by.market.domain.BaseEntity
import by.market.domain.characteristics.Characteristic
import javax.persistence.*

@Entity()
@Table(name = "TBX_S_DATA_TYPE")
class DataType : BaseEntity() {

    @Column(name = "NAME")
    var name: String? = null
        public get
        public set

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dataType")
    var characteristics: Set<Characteristic> = HashSet()

}
