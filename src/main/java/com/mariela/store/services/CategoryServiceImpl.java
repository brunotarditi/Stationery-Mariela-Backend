package com.mariela.store.services;

import com.mariela.store.customExceptions.MyExceptions;
import com.mariela.store.dtos.CategoryDto;
import com.mariela.store.entities.Category;
import com.mariela.store.factories.Factory;
import com.mariela.store.repositories.BaseRepository;
import com.mariela.store.repositories.CategoryRepository;
import com.mariela.store.utils.Message;
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
            return baseRepository.save(category.orElseThrow(() -> new MyExceptions(Message.UPDATE_FAIL)));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
