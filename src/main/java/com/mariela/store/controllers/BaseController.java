package com.mariela.store.controllers;

import com.mariela.store.dtos.BaseDto;
import com.mariela.store.entities.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.io.Serializable;

public interface BaseController <E extends BaseEntity, ID extends Serializable, Dto extends BaseDto>{

    ResponseEntity<?> getAll() throws Exception;
    ResponseEntity<?> getAllEnabled() throws Exception;
    ResponseEntity<?> getAllPageable(@Valid @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "name") String order, @RequestParam(defaultValue = "true") boolean asc) throws Exception;
    ResponseEntity<?> create(@RequestBody Dto dto, BindingResult result) throws Exception;
    ResponseEntity<?> getOne(@PathVariable ID id) throws Exception;
    ResponseEntity<?> delete(@PathVariable ID id) throws Exception;
    ResponseEntity<?> validate (BindingResult result);
}
