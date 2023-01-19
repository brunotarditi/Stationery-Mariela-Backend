package com.mariela.store.controllers;

import com.mariela.store.dtos.BaseDto;
import com.mariela.store.entities.BaseEntity;
import com.mariela.store.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    @GetMapping("/enabled/all")
    public ResponseEntity<?> getAllEnabled() throws Exception {
        try {
            return new ResponseEntity<>(service.findAllEnabled(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> getAllPageable(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "5") int size,
                                            @RequestParam(defaultValue = "name") String order,
                                            @RequestParam(defaultValue = "true") boolean asc) throws Exception {
        try {
            Page<Dto> dtos = service.findAllByPage(PageRequest.of(page, size, Sort.by(order)));
            if (!asc){
                dtos = service.findAllByPage(PageRequest.of(page, size, Sort.by(order).descending()));
            }
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@Valid @RequestBody Dto dto, BindingResult result) throws Exception {
        try {
            if (result.hasErrors()){
                return validate(result);
            }
            return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(Long id) throws Exception {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> validate(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
