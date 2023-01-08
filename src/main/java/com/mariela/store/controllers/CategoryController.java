package com.mariela.store.controllers;

import com.mariela.store.dtos.CategoryDto;
import com.mariela.store.entities.Category;
import com.mariela.store.services.CategoryServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController extends BaseControllerImpl<Category, CategoryServiceImpl, CategoryDto>{
    public CategoryController(CategoryServiceImpl service) {
        super(service);
    }
}
