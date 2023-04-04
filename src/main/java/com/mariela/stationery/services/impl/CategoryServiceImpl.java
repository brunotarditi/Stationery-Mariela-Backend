package com.mariela.stationery.services.impl;

import com.mariela.stationery.dtos.CategoryDto;
import com.mariela.stationery.entities.Category;
import com.mariela.stationery.exceptions.GenericExceptions;
import com.mariela.stationery.factories.Factory;
import com.mariela.stationery.repositories.BaseRepository;
import com.mariela.stationery.repositories.CategoryRepository;
import com.mariela.stationery.dtos.MessageDto;
import com.mariela.stationery.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long, CategoryDto> implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(BaseRepository<Category, Long> baseRepository, Factory<Category, CategoryDto> factory) {
        super(baseRepository, factory);
    }

    @Override
    public Category update(Long id, CategoryDto categoryDto) throws Exception {
        try{
            Optional<Category> category = baseRepository.findById(id);
            if (category.isPresent()){
                category.get().setName(categoryDto.getName());
                category.get().setUpdateAt(new Date());
            }
            return baseRepository.save(category.orElseThrow(() -> new GenericExceptions(MessageDto.UPDATE_FAIL)));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
