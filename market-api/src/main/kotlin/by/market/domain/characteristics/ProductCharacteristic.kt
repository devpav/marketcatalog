package by.market.domain.characteristics

import by.market.domain.BaseEntity
import by.market.domain.system.DataType
import javax.persistence.*


/*
Названия:
* Цвет
* Диаметр
* Тип трубы
* Количество рядов
* */
@Entity
@Table(name = "tbx_ch_characteristic")
class ProductCharacteristic : BaseEntity() {

    @Column(name = "title")
    var title: String? = null

    @ManyToOne
    @JoinColumn(name = "id_data_type")
    var dataType: DataType? = null

}
