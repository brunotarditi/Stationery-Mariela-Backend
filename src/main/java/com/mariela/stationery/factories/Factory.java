package com.mariela.stationery.factories;

public interface Factory <E, Dto>{
    E createEntity (Dto dto);
    Dto createDto (E entity);
}
