package by.market.domain

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(
        name = "TBX_P_PRODUCT",
        indexes = [
            Index(name = "index_p_title", columnList = "TITLE")
        ]
)
open class Product : BaseEntity() {

    @Column(name = "PRICE_VALUE")
    open var priceValue: Int? = null

    @Column(name = "TITLE")
    open var title: String? = null

    @Column(name = "IMAGE")
    open var image: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_CATEGORY")
    open var category: Category? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonBackReference("product_double_characteristics")
    open var characteristicDoubles: Set<DoubleCharacteristic> = HashSet()

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonBackReference("product_string_characteristics")
    open var characteristicStrings: Set<StringCharacteristic> = HashSet()

}
