package com.toni.apifirst.apifirstserver.mappers;

import com.toni.apifirst.apifirstserver.domain.Category;
import com.toni.apifirst.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface CategoryMapper {
    CategoryDto categoryToCategoryDto(Category category);

    @Mapping(target = "products", ignore = true)
    Category categoryDtoToCategory(CategoryDto categoryDto);
}
