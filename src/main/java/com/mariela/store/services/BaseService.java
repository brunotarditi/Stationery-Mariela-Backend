package com.mariela.store.services;

import com.mariela.store.dtos.BaseDto;
import com.mariela.store.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity, ID extends Serializable, Dto extends BaseDto> {
    List<Dto> findAll() throws Exception;
    Optional<Dto> findById(ID id) throws Exception;
    E save(Dto dto) throws Exception;
    void deleteById(ID id) throws Exception;
}
