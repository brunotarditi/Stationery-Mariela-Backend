package com.mariela.store.services;

import com.mariela.store.dtos.CategoryDto;
import com.mariela.store.entities.Category;

public interface CategoryService {
    Category update(Long id, CategoryDto categoryDto) throws Exception;
}
