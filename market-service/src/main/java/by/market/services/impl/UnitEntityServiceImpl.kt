package by.market.services.impl

import by.market.domain.units.UnitEntity
import by.market.repository.UnitEntityRepository
import by.market.services.UnitEntityService
import org.springframework.stereotype.Service

@Service
class UnitEntityServiceImpl(unitEntityRepository: UnitEntityRepository) : BaseService<UnitEntity,
        UnitEntityRepository>(unitEntityRepository), UnitEntityService {

    override fun findByValue(value: String?): UnitEntity? = rep.findByValue(value)

}