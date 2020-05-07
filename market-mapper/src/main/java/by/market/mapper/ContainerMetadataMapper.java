package by.market.mapper;

import by.market.domain.system.ContainerMetadata;
import by.market.dto.system.ContainerMetadataDTO;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface ContainerMetadataMapper extends MapstructMapper<ContainerMetadataDTO, ContainerMetadata> {
}
