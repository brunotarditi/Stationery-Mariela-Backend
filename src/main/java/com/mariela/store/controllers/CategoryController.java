package com.mariela.store.controllers;

import com.mariela.store.dtos.CategoryDto;
import com.mariela.store.entities.Category;
import com.mariela.store.services.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController extends BaseControllerImpl<Category, CategoryServiceImpl, CategoryDto>{
    public CategoryController(CategoryServiceImpl service) {
        super(service);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto, BindingResult result){
        try {
            if (result.hasErrors()){
                return validate(result);
            }
            return new ResponseEntity<>(service.update(id, categoryDto), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
