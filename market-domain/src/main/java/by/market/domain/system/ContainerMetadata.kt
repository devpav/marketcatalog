package by.market.domain.system

import by.market.domain.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

/*
* tbx_s_container (table system)
* */
@Entity
@Table(name = "TBX_S_CONTAINER_METADATA")
class ContainerMetadata : BaseEntity() {

    @Column(name = "DESCRIPTION")
    var description: String? = null

    @Column(name = "SYSTEM_NAME")
    var systemName: String? = null

    @OneToMany(mappedBy = "container")
    @JsonBackReference("container_metadata_entities_metadata")
    var entitiesMetadata: Set<EntityMetadata>? = HashSet()

}
