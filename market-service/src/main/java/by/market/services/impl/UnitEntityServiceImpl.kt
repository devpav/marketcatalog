package by.market.services.impl

import by.market.domain.nosql.TreeUnit
import by.market.domain.units.UnitEntity
import by.market.repository.UnitEntityRepository
import by.market.services.UnitEntityService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class UnitEntityServiceImpl(unitEntityRepository: UnitEntityRepository) : BaseService<UnitEntity,
        UnitEntityRepository>(unitEntityRepository), UnitEntityService {

    override fun findByValue(value: String?): UnitEntity? = rep.findByValue(value)

    @Transactional(readOnly = true)
    open override fun findUnitsTree(): MutableList<TreeUnit> {
        val rootGroups: MutableList<UnitEntity>? = rep.findByUnitGroupIsNull()

        return if (rootGroups.isNullOrEmpty())
            mutableListOf()
        else
            rootGroups.mapNotNull { getRecursionTree(it) }.toMutableList()
    }

    private fun getRecursionTree(treeUnit: UnitEntity): TreeUnit? {
        val unitEntity = rep.findById(treeUnit.id!!)

        if (unitEntity.isPresent) {
            val treeUnitObject: TreeUnit = TreeUnit()

            treeUnitObject.description = treeUnit.description
            treeUnitObject.value = treeUnit.value
            treeUnitObject.id = treeUnit.id

            val groups = treeUnit.groups

            treeUnitObject.subunits = if (groups.isNullOrEmpty())
                mutableListOf()
            else
                groups.mapNotNull { getRecursionTree(it) }.toMutableList()

            return treeUnitObject
        }

        return null
    }


}