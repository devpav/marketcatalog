package by.market.domain.system

import by.market.domain.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/*
* tbx_s_container (table system)
* */
@Entity
@Table(name = "tbx_s_container")
class ContainerMetadata : BaseEntity() {

    @Column(name = "description")
    var description: String? = null
        public get
        public set

    @Column(name = "system_name")
    var systemName: String? = null
        public get
        public set

}
