package by.market.mapper;

import by.market.domain.system.Category;
import by.market.dto.system.CategoryDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface CategoryMapper extends MapstructMapper<CategoryDTO, Category> {

    @Override
    @Mapping(source = "parentCategory.id", target = "parent")
    CategoryDTO toMap(Category category);

    @Override
    @InheritInverseConfiguration
    Category fromMap(CategoryDTO categoryDTO);
}
