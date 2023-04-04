package com.mariela.stationery.services.impl;

import com.mariela.stationery.dtos.ProductDto;
import com.mariela.stationery.entities.Product;
import com.mariela.stationery.exceptions.GenericExceptions;
import com.mariela.stationery.factories.Factory;
import com.mariela.stationery.repositories.BaseRepository;
import com.mariela.stationery.repositories.ProductRepository;
import com.mariela.stationery.dtos.MessageDto;
import com.mariela.stationery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long, ProductDto> implements ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(BaseRepository<Product, Long> baseRepository, Factory<Product, ProductDto> factory) {
        super(baseRepository, factory);
    }

    @Override
    public Product update(Long id, ProductDto productDto) throws Exception {
        try {
            Optional<Product> product = baseRepository.findById(id);
            if (product.isPresent()){
                product.get().setName(productDto.getName());
                product.get().setUpdateAt(new Date());
                product.get().setCategory(productDto.getCategory());
            }
            return baseRepository.save(product.orElseThrow(()-> new GenericExceptions(MessageDto.UPDATE_FAIL)));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
