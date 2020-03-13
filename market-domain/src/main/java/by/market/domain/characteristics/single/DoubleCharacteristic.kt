package by.market.domain.characteristics.single

import by.market.domain.characteristics.AbstractSingleCharacteristic
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Table(
        name = "tbx_ch_double_characteristic",
        indexes = [
            Index(name = "double_characteristic_id_entity_metadata_id_product_row_idx", columnList = "id_entity_metadata,id_product_row")
        ]
)
@Entity()
class DoubleCharacteristic : AbstractSingleCharacteristic<Double>()
