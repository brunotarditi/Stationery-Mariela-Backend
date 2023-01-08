package com.mariela.store.services;

import com.mariela.store.dtos.CategoryDto;
import com.mariela.store.entities.Category;
import com.mariela.store.factories.Factory;
import com.mariela.store.repositories.BaseRepository;
import com.mariela.store.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long, CategoryDto>{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(BaseRepository<Category, Long> baseRepository, Factory<Category, CategoryDto> factory, CategoryRepository categoryRepository) {
        super(baseRepository, factory);
        this.categoryRepository = categoryRepository;
    }
}
