package com.mariela.stationery.services;

import com.mariela.stationery.dtos.CategoryDto;
import com.mariela.stationery.entities.Category;

public interface CategoryService {
    Category update(Long id, CategoryDto categoryDto) throws Exception;
}
