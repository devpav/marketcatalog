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
        public get
        public set

    @Column(name = "img")
    var img: String? = null
        public get
        public set

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    var category: Category? = null
        public get
        public set
}
