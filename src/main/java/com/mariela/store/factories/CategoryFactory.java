package com.mariela.store.factories;

import com.mariela.store.dtos.CategoryDto;
import com.mariela.store.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory implements Factory<Category, CategoryDto>{
    @Override
    public Category createEntity(CategoryDto categoryDto) {
        return Category.builder()
                .name(categoryDto.getName())
                .build();
    }

    @Override
    public CategoryDto createDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .createAt(category.getCreateAt())
                .updateAt(category.getUpdateAt())
                .isEnabled(category.isEnabled())
                .build();
    }
}
