package com.mariela.store.controllers;

import com.mariela.store.dtos.BaseDto;
import com.mariela.store.entities.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

public interface BaseController <E extends BaseEntity, ID extends Serializable, Dto extends BaseDto>{

    ResponseEntity<?> getAll() throws Exception;
    ResponseEntity<?> create(@RequestBody Dto dto);
}
