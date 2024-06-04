package com.toni.apifirst.apifirstserver.controllers;

import com.toni.apifirst.apifirstserver.services.CategoryService;
import com.toni.apifirst.model.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.toni.apifirst.apifirstserver.controllers.CategoryController.BASE_URL;



@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class CategoryController {
    public static final String BASE_URL = "/v1/categories";

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        return ResponseEntity.ok(categoryService.listCategories());
    }
}
