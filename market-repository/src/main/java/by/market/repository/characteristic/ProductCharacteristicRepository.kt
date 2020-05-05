package by.market.repository.characteristic

import by.market.domain.characteristics.Characteristic
import by.market.domain.system.DataType
import by.market.repository.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCharacteristicRepository : BaseRepository<Characteristic> {

    fun existsByTitleAndDataType(title: String, dataType: DataType): Boolean

    fun findByTitleAndDataType(title: String, dataType: DataType): Characteristic?

}
