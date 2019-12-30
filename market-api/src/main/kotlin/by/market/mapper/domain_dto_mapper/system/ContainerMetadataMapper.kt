package by.market.mapper.domain_dto_mapper.system

import by.market.domain.system.ContainerMetadata
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig
import by.market.mapper.dto.system.ContainerMetadataFrontEnd
import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ContainerMetadataMapper : IMapstructMapper<ContainerMetadataFrontEnd, ContainerMetadata>
