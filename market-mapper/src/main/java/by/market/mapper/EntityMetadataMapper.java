package by.market.mapper;


import by.market.domain.system.EntityMetadata;
import by.market.dto.system.EntityMetadataDTO;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class, uses = ContainerMetadataMapper.class)
public interface EntityMetadataMapper extends MapstructMapper<EntityMetadataDTO, EntityMetadata> {
}
