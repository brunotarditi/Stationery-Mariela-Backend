package com.mariela.store.services;

import com.mariela.store.dtos.BaseDto;
import com.mariela.store.entities.BaseEntity;
import com.mariela.store.factories.Factory;
import com.mariela.store.repositories.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseServiceImpl<E extends BaseEntity, ID extends Serializable, Dto extends BaseDto> implements BaseService<E, ID, Dto> {
    protected BaseRepository<E, ID> baseRepository;
    protected Factory<E, Dto> factory;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository, Factory<E, Dto> factory) {
        this.baseRepository = baseRepository;
        this.factory = factory;
    }

    @Override
    public List<Dto> findAll() throws Exception {
        try {
            List<E> entities = (List<E>) baseRepository.findAll();
            return entities.stream().map(e -> factory.createDto(e)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Optional<Dto> findById(ID id) throws Exception {
        return Optional.empty();
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
    public void deleteById(ID id) throws Exception {

    }
}
