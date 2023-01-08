package com.mariela.store.factories;

import com.mariela.store.dtos.CategoryDto;
import com.mariela.store.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory implements Factory<Category, CategoryDto>{
    @Override
    public Category createEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }

    @Override
    public CategoryDto createDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .isEnabled(category.isEnabled())
                .build();
    }
}
