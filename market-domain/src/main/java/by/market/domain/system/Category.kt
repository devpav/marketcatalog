package by.market.domain.system

import by.market.domain.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "TBX_S_CATEGORY", indexes = [
    Index(name = "index_s_system_name_category", columnList = "SYSTEM_NAME")
])
class Category : BaseEntity() {

    @Column(name = "TITLE")
    var title: String? = null

    @Column(name = "SYSTEM_NAME")
    var systemName: String? = null

    @ManyToOne
    @JoinColumn(name = "FK_PARENT_CATEGORY")
    @JsonBackReference("category_child")
    var parentCategory: Category? = null

    @Column(name = "IMAGE_VALUE")
    var img: String? = null

    val isParent: Boolean
        get() = id == parentCategory?.id

}
