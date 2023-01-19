package com.mariela.store.services;

import com.mariela.store.dtos.BaseDto;
import com.mariela.store.entities.BaseEntity;
import com.mariela.store.utils.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity, ID extends Serializable, Dto extends BaseDto> {
    List<Dto> findAll() throws Exception;
    List<Dto> findAllEnabled() throws Exception;
    Page<Dto> findAllByPage(Pageable pageable) throws Exception;
    Optional<Dto> findById(ID id) throws Exception;
    E save(Dto dto) throws Exception;
    HashMap<String, Object> deleteById(ID id) throws Exception;
}
