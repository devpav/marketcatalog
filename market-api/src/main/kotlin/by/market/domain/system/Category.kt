package by.market.domain.system

import by.market.domain.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "tbx_s_category", indexes = [
    Index(name = "index_s_system_name_category", columnList = "system_name")
])
class Category : BaseEntity() {

    @Column(name = "title")
    var title: String? = null;

    @Column(name = "system_name")
    var systemName: String? = null;

    @ManyToOne
    @JoinColumn(name = "id_parent_category")
    @JsonBackReference("category_child")
    var childCategory: Category? = null
}
