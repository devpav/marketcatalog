package by.market.domain

import by.market.domain.system.Category
import javax.persistence.*

@MappedSuperclass
@Table(indexes = [
    Index(name = "index_p_title", columnList = "title")
])
open class AbstractProduct : BaseEntity() {

    @Column(name = "title")
    var title: String? = null

    @Column(name = "img")
    var img: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    var category: Category? = null

}
