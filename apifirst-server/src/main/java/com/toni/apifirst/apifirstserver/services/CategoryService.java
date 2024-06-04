package com.toni.apifirst.apifirstserver.services;

import com.toni.apifirst.model.CategoryDto;

import java.util.List;


public interface CategoryService {

    List<CategoryDto> listCategories();
}
