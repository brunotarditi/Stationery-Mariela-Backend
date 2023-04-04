package com.mariela.stationery.repositories;

import com.mariela.stationery.entities.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
}
