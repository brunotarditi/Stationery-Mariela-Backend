package com.mariela.stationery.repositories;

import com.mariela.stationery.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
}
