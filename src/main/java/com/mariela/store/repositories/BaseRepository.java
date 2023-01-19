package com.mariela.store.repositories;

import com.mariela.store.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository <E extends BaseEntity, ID extends Serializable> extends PagingAndSortingRepository<E, ID> {
    List<E> findByIsEnabledTrue();
}
