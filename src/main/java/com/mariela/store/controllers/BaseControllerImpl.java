package com.mariela.store.controllers;

import com.mariela.store.dtos.BaseDto;
import com.mariela.store.entities.BaseEntity;
import com.mariela.store.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseControllerImpl<E extends BaseEntity, S extends BaseServiceImpl<E, Long, Dto>, Dto extends BaseDto> implements BaseController<E, Long, Dto> {
    protected S service;

    @Autowired
    public BaseControllerImpl(S service) {
        this.service = service;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<?> getAll() throws Exception {
        try {
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@RequestBody Dto dto) {
        try {
            return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
