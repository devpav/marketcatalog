package by.market.domain.characteristics.single

import by.market.domain.characteristics.AbstractCharacteristic
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(
    name = "TBX_CH_STRING_CHARACTERISTIC",
    indexes = [
        Index(name = "string_characteristic_id_entity_metadata_id_product_row_idx", columnList = "FK_ENTITY_METADATA, FK_PRODUCT")
    ]
)
class StringCharacteristic : AbstractCharacteristic<String>()
