package com.toni.apifirst.apifirstserver.services;

import com.toni.apifirst.apifirstserver.mappers.CategoryMapper;
import com.toni.apifirst.apifirstserver.repositories.CategoryRepository;
import com.toni.apifirst.model.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> listCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDto)
                .toList();
    }
}
