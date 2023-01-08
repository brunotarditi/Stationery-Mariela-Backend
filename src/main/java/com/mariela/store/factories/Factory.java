package com.mariela.store.factories;

public interface Factory <E, Dto>{
    E createEntity (Dto dto);
    Dto createDto (E entity);
}
