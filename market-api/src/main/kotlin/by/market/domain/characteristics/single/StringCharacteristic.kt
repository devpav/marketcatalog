package by.market.domain.characteristics.single

import by.market.domain.characteristics.AbstractSingleCharacteristic
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Entity()
@Table(
    name = "tbx_ch_string_characteristic",
    indexes = [
        Index(name = "string_characteristic_id_entity_metadata_id_product_row_idx", columnList = "id_entity_metadata,id_product_row")
    ]
)
class StringCharacteristic : AbstractSingleCharacteristic<String>()
