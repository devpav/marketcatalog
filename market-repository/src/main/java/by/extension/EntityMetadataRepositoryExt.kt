package by.market.repository.extension

import by.market.core.Constant
import by.market.domain.system.EntityMetadata
import by.market.repository.system.EntityMetadataRepository

fun EntityMetadataRepository.findAccessory(): EntityMetadata = findByTableName(Constant.EntityMetadata.Accessory)

fun EntityMetadataRepository.findCornice(): EntityMetadata = findByTableName(Constant.EntityMetadata.Cornice)

fun EntityMetadataRepository.findJalousie(): EntityMetadata = findByTableName(Constant.EntityMetadata.Jalousie)

fun EntityMetadataRepository.findRolstor(): EntityMetadata = findByTableName(Constant.EntityMetadata.Rolstor)