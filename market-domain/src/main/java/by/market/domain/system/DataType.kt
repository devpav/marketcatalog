package by.market.domain.system

import by.market.domain.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity()
@Table(name = "tbx_s_data_type")
class DataType : BaseEntity() {

    @Column(name = "name")
    var name: String? = null
        public get
        public set

}
