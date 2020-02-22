package by.market.repository.extension

import by.market.core.Constant
import by.market.domain.system.DataType
import by.market.repository.system.DataTypeRepository

fun DataTypeRepository.findString(): DataType = findByName(Constant.DataType.String)

fun DataTypeRepository.findDouble(): DataType = findByName(Constant.DataType.Double)