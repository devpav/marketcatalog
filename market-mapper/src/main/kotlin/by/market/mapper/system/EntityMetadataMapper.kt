package by.market.mapper.system

import by.market.domain.system.EntityMetadata
import by.market.dto.system.EntityMetadataDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface EntityMetadataMapper : IMapstructMapper<EntityMetadataDTO, EntityMetadata>
