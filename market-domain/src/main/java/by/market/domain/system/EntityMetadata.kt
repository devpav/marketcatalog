package by.market.domain.system

import by.market.domain.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

/*
* tbx_s_container (table system)
* */
@Entity(name = "tbx_s_entity_metadata")
class EntityMetadata : BaseEntity() {

    @Column(name = "table_name")
    var tableName: String? = null
        public get
        public set

    @Column(name = "description")
    var description: String? = null
        public get
        public set

    @ManyToOne
    @JoinColumn(name = "id_container")
    var container: ContainerMetadata? = null
        public get
        public set
}
