package by.market.domain.product

import by.market.domain.AbstractProduct
import javax.persistence.Entity
import javax.persistence.Table

/*
* Жалюзи
* */
@Entity
@Table(name = "tbx_p_blind")
class ProductBlind : AbstractProduct()
