package com.codegym.c0320h1.service;

import com.codegym.c0320h1.exception.NotFoundException;

import java.util.List;

public interface IService<T> {
    Iterable<T> findAll();

    T findById(Long id) throws NotFoundException;

    void update(T model);
    void save(T model);

    void remove(Long id);
}
