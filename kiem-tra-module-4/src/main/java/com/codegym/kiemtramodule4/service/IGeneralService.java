package com.codegym.kiemtramodule4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);

    Optional<T> findById(Integer id);

    void save(T object);

    void delete(Integer id);
}
