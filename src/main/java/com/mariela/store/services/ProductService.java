package com.mariela.store.services;

import com.mariela.store.dtos.ProductDto;
import com.mariela.store.entities.Product;

public interface ProductService {
    Product update(Long id, ProductDto productDto) throws Exception;
}
