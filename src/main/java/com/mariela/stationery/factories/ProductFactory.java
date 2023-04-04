package com.mariela.stationery.factories;

import com.mariela.stationery.dtos.ProductDto;
import com.mariela.stationery.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFactory implements Factory<Product, ProductDto>{
    @Override
    public Product createEntity(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .category(productDto.getCategory())
                .build();
    }

    @Override
    public ProductDto createDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .createAt(product.getCreateAt())
                .updateAt(product.getUpdateAt())
                .isEnabled(product.isEnabled())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
    }
}
