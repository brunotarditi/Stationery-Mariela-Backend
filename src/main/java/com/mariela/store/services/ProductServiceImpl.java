package com.mariela.store.services;

import com.mariela.store.customExceptions.MyExceptions;
import com.mariela.store.dtos.ProductDto;
import com.mariela.store.entities.Category;
import com.mariela.store.entities.Product;
import com.mariela.store.factories.Factory;
import com.mariela.store.repositories.BaseRepository;
import com.mariela.store.repositories.CategoryRepository;
import com.mariela.store.repositories.ProductRepository;
import com.mariela.store.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long, ProductDto> implements ProductService{
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
            return baseRepository.save(product.orElseThrow(()-> new MyExceptions(Message.UPDATE_FAIL)));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
