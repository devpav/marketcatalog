package by.market.domain.product

import by.market.domain.AbstractProduct
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbx_p_accessory")
class ProductAccessory : AbstractProduct()
