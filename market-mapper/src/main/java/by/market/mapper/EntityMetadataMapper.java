package by.market.mapper;


import by.market.domain.system.EntityMetadata;
import by.market.dto.system.EntityMetadataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class, uses = ContainerMetadataMapper.class)
public interface EntityMetadataMapper extends MapstructMapper<EntityMetadataDTO, EntityMetadata> {

    @Override
    @Mapping(source = "container.id", target = "container")
    EntityMetadataDTO toMap(EntityMetadata entityMetadata);

    @Override
    @Mapping(source = "container", target = "container.id")
    EntityMetadata fromMap(EntityMetadataDTO entityMetadataDTO);

}
