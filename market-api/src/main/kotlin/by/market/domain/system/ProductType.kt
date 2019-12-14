package by.market.domain.system

import by.market.domain.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbx_s_product_type")
class ProductType : BaseEntity() {

    private var title: String? = null;

}
