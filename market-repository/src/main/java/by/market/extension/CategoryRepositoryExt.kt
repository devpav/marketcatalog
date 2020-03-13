package by.market.extension

import by.market.core.Constant
import by.market.domain.system.Category
import by.market.repository.system.CategoryRepository

fun CategoryRepository.findAccessory(): Category? = findBySystemName(Constant.Category.Accessory)

fun CategoryRepository.findCornice(): Category? = findBySystemName(Constant.Category.Cornice)

fun CategoryRepository.findJalousie(): Category? = findBySystemName(Constant.Category.Jalousie)

fun CategoryRepository.findRolstor(): Category? = findBySystemName(Constant.Category.Rolstor)