package by.market.mapper;

import by.market.domain.units.UnitEntity;
import by.market.dto.UnitEntityDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(config = MapperConfiguration.class)
public interface UnitEntityMapper extends MapstructMapper<UnitEntityDTO, UnitEntity> {

    @Mappings({
            @Mapping(source = "unitGroup.id", target = "unitGroup")
    })
    UnitEntityDTO toMap(UnitEntity entity);

    @InheritInverseConfiguration
    UnitEntity fromMap(UnitEntityDTO tdto);

}
