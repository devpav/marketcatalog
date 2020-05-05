package by.market.domain.system

import by.market.domain.BaseEntity
import by.market.domain.Product
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "TBX_S_CATEGORY", indexes = [
    Index(name = "index_s_system_name_category", columnList = "SYSTEM_NAME")
])
@Cacheable
class Category : BaseEntity() {

    @Column(name = "TITLE")
    var title: String? = null

    @Column(name = "SYSTEM_NAME")
    var systemName: String? = null

    @Column(name = "IMAGE_VALUE")
    var image: String? = null

    @OneToMany(mappedBy = "category", targetEntity = Product::class, fetch = FetchType.LAZY)
    var products: Set<Product> = HashSet()

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    var subCategories: Set<Category> = HashSet()

    @ManyToOne
    @JoinColumn(name = "FK_PARENT_CATEGORY")
    @JsonBackReference("category_child")
    var parentCategory: Category? = null

    val isParent: Boolean
        get() = id == parentCategory?.id

}
