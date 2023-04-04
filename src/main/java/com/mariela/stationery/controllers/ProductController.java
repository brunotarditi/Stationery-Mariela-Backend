package com.mariela.stationery.controllers;

import com.mariela.stationery.dtos.ProductDto;
import com.mariela.stationery.entities.Product;
import com.mariela.stationery.services.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/products")
public class ProductController extends BaseControllerImpl<Product, ProductServiceImpl, ProductDto>{
    public ProductController(ProductServiceImpl service) {
        super(service);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProductDto productDto, BindingResult result){
        try {
            if (result.hasErrors()){
                return validate(result);
            }
            return new ResponseEntity<>(service.update(id, productDto), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
