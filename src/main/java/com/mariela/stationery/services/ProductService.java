package com.mariela.stationery.services;

import com.mariela.stationery.dtos.ProductDto;
import com.mariela.stationery.entities.Product;

public interface ProductService {
    Product update(Long id, ProductDto productDto) throws Exception;
}
