package by.market.mapper;

import by.market.domain.system.DataType;
import by.market.dto.system.DataTypeDTO;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DataTypeMapper extends MapstructMapper<DataTypeDTO, DataType> {
}
