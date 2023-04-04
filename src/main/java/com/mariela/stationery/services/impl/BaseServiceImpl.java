package com.mariela.stationery.services.impl;

import com.mariela.stationery.dtos.BaseDto;
import com.mariela.stationery.entities.BaseEntity;
import com.mariela.stationery.factories.Factory;
import com.mariela.stationery.repositories.BaseRepository;
import com.mariela.stationery.dtos.MessageDto;
import com.mariela.stationery.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class BaseServiceImpl<E extends BaseEntity, ID extends Serializable, Dto extends BaseDto> implements BaseService<E, ID, Dto> {
    protected BaseRepository<E, ID> baseRepository;
    protected Factory<E, Dto> factory;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository, Factory<E, Dto> factory) {
        this.baseRepository = baseRepository;
        this.factory = factory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dto> findAll() throws Exception {
        try {
            List<E> entities = (List<E>) baseRepository.findAll();
            return entities.stream().map(e -> factory.createDto(e)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Dto> findAllEnabled() throws Exception {
        try {
            List<E> entities = (List<E>) baseRepository.findByIsEnabledTrue();
            return entities.stream().map(e -> factory.createDto(e)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Dto> findAllByPage(Pageable pageable) throws Exception {
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            List<Dto> dtos = entities.stream().map(e -> factory.createDto(e)).collect(Collectors.toList());
            return new PageImpl<>(dtos);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Dto findById(ID id) {
        E entity = baseRepository.findById(id).orElseThrow(() -> {throw new NoSuchElementException(MessageDto.NOT_FOUND); });
        return factory.createDto(entity);
    }

    @Override
    public E save(Dto dto) throws Exception {
        try {
            E e = factory.createEntity(dto);
            return baseRepository.save(e);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MessageDto deleteById(ID id) {
        E entity = baseRepository.findById(id).orElseThrow(() -> { throw new NoSuchElementException(MessageDto.DELETE_FAIL); });
        entity.setEnabled(false);
        entity.setUpdateAt(new Date());
        baseRepository.save(entity);
        return new MessageDto(MessageDto.DELETE_SUCCESS);
    }
}
