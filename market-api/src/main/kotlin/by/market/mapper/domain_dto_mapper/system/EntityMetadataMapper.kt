package by.market.mapper.domain_dto_mapper.system

import by.market.domain.system.EntityMetadata
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.dto.system.EntityMetadataFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface EntityMetadataMapper : IMapstructMapper<EntityMetadataFrontEnd, EntityMetadata>