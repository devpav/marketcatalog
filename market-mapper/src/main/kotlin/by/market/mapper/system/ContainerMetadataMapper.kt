package by.market.mapper.system

import by.market.domain.system.ContainerMetadata
import by.market.dto.system.ContainerMetadataDTO
import by.market.mapper.IMapstructMapper
import by.market.mapper.MapperConfig

import org.mapstruct.Mapper

@Mapper(config = MapperConfig::class)
interface ContainerMetadataMapper : IMapstructMapper<ContainerMetadataDTO, ContainerMetadata>
