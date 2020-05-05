package by.market.domain

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "TBX_P_PRODUCT",
        indexes = [
            Index(name = "index_p_title", columnList = "TITLE")
        ])
open class Product : BaseEntity() {

    @Column(name = "PRICE_VALUE")
    var priceValue: Int? = null

    @Column(name = "TITLE")
    var title: String? = null

    @Column(name = "IMAGE")
    var image: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_CATEGORY")
    var category: Category? = null

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonBackReference("product_double_characteristics")
    var characteristicDoubles: Set<DoubleCharacteristic> = HashSet()

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonBackReference("product_string_characteristics")
    var characteristicStrings: Set<StringCharacteristic> = HashSet()

}
