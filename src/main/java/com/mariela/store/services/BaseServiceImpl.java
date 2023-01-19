package com.mariela.store.services;

import com.mariela.store.customExceptions.MyExceptions;
import com.mariela.store.dtos.BaseDto;
import com.mariela.store.entities.BaseEntity;
import com.mariela.store.factories.Factory;
import com.mariela.store.repositories.BaseRepository;
import com.mariela.store.utils.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
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
    public Optional<Dto> findById(ID id) throws Exception {
        try {
            Optional<E> entity = baseRepository.findById(id);
            return entity
                    .stream()
                    .map(e -> factory.createDto(e))
                    .findFirst();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
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
    public HashMap<String, Object> deleteById(ID id) throws Exception {
        try {
            HashMap<String, Object> response = new HashMap<>();
            Optional<E> entity = baseRepository.findById(id);
            if (entity.isPresent()){
                entity.get().setEnabled(false);
                entity.get().setUpdateAt(new Date());
                baseRepository.save(entity.get());
                response.put("response", Message.DELETE_SUCCESS);
                return response;
            }
            response.put("response", Message.DELETE_FAIL);
            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
