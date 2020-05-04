package by.market.domain.system

import by.market.domain.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/*
* tbx_s_container (table system)
* */
@Entity
@Table(name = "TBX_S_CONTAINER")
class ContainerMetadata : BaseEntity() {

    @Column(name = "DESCRIPTION")
    var description: String? = null
        public get
        public set

    @Column(name = "SYSTEM_NAME")
    var systemName: String? = null
        public get
        public set

}
