package by.market.domain.product

import by.market.domain.AbstractProduct
import javax.persistence.Entity
import javax.persistence.Table

/*
* Рольштора
* */
@Entity
@Table(name = "tbx_p_curtain")
class ProductCurtain : AbstractProduct()
