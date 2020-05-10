package by.market.mapper;

import by.market.domain.nosql.TreeUnit;
import by.market.dto.TreeUnitDTO;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface UnitEntityTreeMapper extends MapstructMapper<TreeUnitDTO, TreeUnit> {}
