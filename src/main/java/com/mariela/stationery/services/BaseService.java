package com.mariela.stationery.services;

import com.mariela.stationery.dtos.BaseDto;
import com.mariela.stationery.dtos.MessageDto;
import com.mariela.stationery.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity, ID extends Serializable, Dto extends BaseDto> {
    List<Dto> findAll() throws Exception;
    List<Dto> findAllEnabled() throws Exception;
    Page<Dto> findAllByPage(Pageable pageable) throws Exception;
    Dto findById(ID id);
    E save(Dto dto) throws Exception;
    MessageDto deleteById(ID id);
}
