package by.market.domain

import by.market.domain.characteristics.single.DoubleCharacteristic
import by.market.domain.characteristics.single.StringCharacteristic
import by.market.domain.system.Category
import javax.persistence.*

@Entity
@Table(indexes = [
    Index(name = "index_p_title", columnList = "title")
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PRODUCT")
    var doubleCharacteristics: Set<DoubleCharacteristic> = HashSet()

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PRODUCT")
    var stringCharacteristics: Set<StringCharacteristic> = HashSet()

}
