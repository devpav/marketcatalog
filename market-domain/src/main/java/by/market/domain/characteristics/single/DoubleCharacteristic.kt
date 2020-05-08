package by.market.domain.characteristics.single

import by.market.domain.characteristics.AbstractCharacteristic
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Table(
        name = "TBX_CH_DOUBLE_CHARACTERISTIC",
        indexes = [
            Index(name = "double_characteristic_id_entity_metadata_id_product_row_idx", columnList = "FK_ENTITY_METADATA, FK_PRODUCT")
        ]
)
@Entity()
class DoubleCharacteristic : AbstractCharacteristic<Double>()
