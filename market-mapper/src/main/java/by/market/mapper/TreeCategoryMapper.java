package by.market.mapper;

import by.market.domain.nosql.TreeCategory;
import by.market.dto.TreeCategoryDTO;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface TreeCategoryMapper extends MapstructMapper<TreeCategoryDTO, TreeCategory> { }
