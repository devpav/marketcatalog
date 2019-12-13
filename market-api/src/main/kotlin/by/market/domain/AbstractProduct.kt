package by.market.domain

import by.market.domain.system.Category
import javax.persistence.Column
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class AbstractProduct : BaseEntity() {

    @Column(name = "title")
    var title: String? = null

    @Column(name = "img")
    var img: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    var category: Category? = null

}
