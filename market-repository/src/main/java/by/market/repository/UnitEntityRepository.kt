package by.market.repository

import by.market.domain.units.UnitEntity
import org.springframework.stereotype.Repository

@Repository
interface UnitEntityRepository : BaseRepository<UnitEntity> {

    fun findByValue(value: String): UnitEntity?

}