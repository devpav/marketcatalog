package by.market.domain.units

import by.market.domain.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "TBX_RB_UNIT")
class UnitEntity : BaseEntity() {

    @Column(name = "VALUE")
    var value: String? = null

    @Column(name = "DESCRIPTION")
    var description: String? = null

    @OneToMany(mappedBy = "group")
    var groups: MutableList<UnitEntity>? = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "FK_UNIT_GROUP")
    var group: UnitEntity? = null

}